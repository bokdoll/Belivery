package com.ppusheoppusheo.belivery.ui.map

import android.Manifest
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.ui.map.dialog.DialogMapDeliveryEnd
import com.ppusheoppusheo.belivery.ui.map.dialog.DialogMapNotOrdered
import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.lang.Exception


class MapActivity : AppCompatActivity() {

    lateinit var mapView: MapView
    lateinit var lm: LocationManager

    // -1 : 배달 중 , 0 : 주문 전, 1 : 배달 완료
    var status_flag: Int = -1


    private val GPS_ENABLE_REQUEST_CODE = 2001
    private val PERMISSIONS_REQUEST_CODE = 100

    private val REQUIRED_PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapView = MapView(this@MapActivity)
        mapView.setDaumMapApiKey("c40e78d2bd41c37abe418f6cf4595c75")

        initView(status_flag)

    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff)
        mapView.setShowCurrentLocationMarker(false)
    }

    private fun initView(flag: Int) {
        Log.d("현주", flag.toString())
        val mapViewContainer = findViewById<ViewGroup>(R.id.mapview)

        ((cl_map_top.parent) as ViewGroup).removeView(cl_map_top)
        ((cl_map_rider_info.parent) as ViewGroup).removeView(cl_map_rider_info)

        mapViewContainer.addView(mapView)
        mapViewContainer.addView(cl_map_top)

        // 뒤로 가기 버튼
        btn_map_back.setOnClickListener {
            finish()
        }

        if (flag == 0) {    // 주문 전
                tv_map_location.text = "지도"
                tv_map_location_description.visibility = View.GONE
                displayDialog(flag)

        } else {
            mapViewContainer.addView(cl_map_rider_info)

            //전화 걸기를 눌렀을 때
            btn_map_rider_tel.setOnClickListener {
                openDial("01049490303")
            }


            if (flag == 1) { //배달 완료
                tv_map_location_description.text = "으로 배달 완료"
                displayDialog(flag)


            } else {   //배달 중
                displayCurrentLocation()
            }
        }
    }

    // 현재 우리 집 표시하기
    private fun displayCurrentLocation() {
        if (!checkLocationServicesStatus()) {
            showDialogForLocationServiceSetting()
        } else {
            checkRunTimePermission()
        }

        lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        if (location != null) {
            val long = location.longitude
            val lat = location.latitude
            onCurrentLocationUpdate(mapView, MapPoint.mapPointWithGeoCoord(lat, long), 0.0001f)
        }

        mapView.setCustomCurrentLocationMarkerTrackingImage(
            R.drawable.my_home_map,
            MapPOIItem.ImageOffset(23, 23)
        )
        mapView.currentLocationTrackingMode =
            MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
    }

    private fun openDial(num: String) {
        val tel = "tel:".plus(num)
        val intent = Intent("android.intent.action.DIAL", Uri.parse(tel))
        startActivity(intent)
    }

    private fun displayDialog(flag: Int) {
        lateinit var mapDialog: Dialog
        when (flag) {
            0 -> mapDialog = DialogMapNotOrdered(this@MapActivity)     // 주문 전
            1 -> mapDialog = DialogMapDeliveryEnd(this@MapActivity)    // 배달 완료
        }

        mapDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //mapDialog.setCanceledOnTouchOutside(true)
        mapDialog.show()
    }

    fun onCurrentLocationUpdate(
        mapView: MapView,
        currentLocation: MapPoint,
        accuracyInMeters: Float
    ) {
        val mapPointGeo = currentLocation.mapPointGeoCoord
        Log.i(
            "MapActivity",
            String.format(
                "MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)",
                mapPointGeo.latitude,
                mapPointGeo.longitude,
                accuracyInMeters
            )
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {


        if (requestCode == PERMISSIONS_REQUEST_CODE && grantResults.size == REQUIRED_PERMISSIONS.size) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            var check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (result in grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false
                    break
                }
            }

            if (check_result) {
                //위치 값을 가져올 수 있음
            } else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        REQUIRED_PERMISSIONS[0]
                    )
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        REQUIRED_PERMISSIONS[1]
                    )
                ) {

                    Toast.makeText(
                        applicationContext,
                        "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.",
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ",
                        Toast.LENGTH_LONG
                    ).show();

                }
            }

        }
    }


    fun checkRunTimePermission() {

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(
            this@MapActivity,
            Manifest.permission.ACCESS_FINE_LOCATION
        );


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음
            mapView.currentLocationTrackingMode =
                MapView.CurrentLocationTrackingMode.TrackingModeOff


        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@MapActivity,
                    REQUIRED_PERMISSIONS[0]
                )
            ) {

                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(this@MapActivity, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG)
                    .show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(
                    this@MapActivity, REQUIRED_PERMISSIONS,
                    PERMISSIONS_REQUEST_CODE
                )


            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(
                    this@MapActivity, REQUIRED_PERMISSIONS,
                    PERMISSIONS_REQUEST_CODE
                )
            }

        }

    }

    //여기부터는 GPS 활성화를 위한 메소드들
    fun showDialogForLocationServiceSetting() {

        val builder = AlertDialog.Builder(this@MapActivity)
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage(
            "앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                    + "위치 설정을 수정하실래요?"
        );
        builder.setCancelable(true);
        builder.setPositiveButton("설정") { dialogInterface, i ->
            val callGPSSettingIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
        }
        builder.setNegativeButton("취소") { dialogInterface, i ->
            dialogInterface.cancel()
        }

        builder.create().show()
    }

    fun checkLocationServicesStatus(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
}
