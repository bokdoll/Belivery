package com.ppusheoppusheo.belivery.ui.restaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.RestaurantData
import com.ppusheoppusheo.belivery.ui.restaurant.adapter.RestaurantRVAdapter
import com.ppusheoppusheo.belivery.util.ApplicationController
import com.ppusheoppusheo.belivery.util.NetworkService
import kotlinx.android.synthetic.main.activity_restaurant.*


class RestaurantActivity : AppCompatActivity() {

    lateinit var restaurantRVAdapter: RestaurantRVAdapter
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        networkService = ApplicationController.networkService

        initView()
    }

    private fun initView(){
        val intent = Intent(this.intent)
        var page_num : Int = intent.getIntExtra("menu_num", -1)
        selectPage(page_num)

        getRestaurantResponse()



        cl_restaurant_top.setOnClickListener{
            finish()
        }
    }

    // 식당 서버 통신은 아직 구현 안됨
    private fun getRestaurantResponse(){
        var tmp : ArrayList<RestaurantData> = ArrayList<RestaurantData>()

        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "국대 떡볶이 마포역점", 4.2f, 14000, "육개장, 뼈다귀해장국", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "청년다방 숙대입구점", 4.3f, 15000, "차돌 떡볶이, 통큰오짱 떡볶이", "52~62분", 2000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "서울역철도떡볶이 서울역본점", 4.7f, 7000, "철도즉석국물떡볶이, 철도 떡볶이", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "국대 떡볶이 마포역점", 4.2f, 14000, "육개장, 뼈다귀해장국", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "청년다방 숙대입구점", 4.3f, 15000, "차돌 떡볶이, 통큰오짱 떡볶이", "52~62분", 2000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "서울역철도떡볶이 서울역본점", 4.7f, 7000, "철도즉석국물떡볶이, 철도 떡볶이", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "국대 떡볶이 마포역점", 4.2f, 14000, "육개장, 뼈다귀해장국", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "청년다방 숙대입구점", 4.3f, 15000, "차돌 떡볶이, 통큰오짱 떡볶이", "52~62분", 2000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "서울역철도떡볶이 서울역본점", 4.7f, 7000, "철도즉석국물떡볶이, 철도 떡볶이", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "국대 떡볶이 마포역점", 4.2f, 14000, "육개장, 뼈다귀해장국", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "청년다방 숙대입구점", 4.3f, 15000, "차돌 떡볶이, 통큰오짱 떡볶이", "52~62분", 2000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "서울역철도떡볶이 서울역본점", 4.7f, 7000, "철도즉석국물떡볶이, 철도 떡볶이", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "국대 떡볶이 마포역점", 4.2f, 14000, "육개장, 뼈다귀해장국", "52~62분", 3000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "청년다방 숙대입구점", 4.3f, 15000, "차돌 떡볶이, 통큰오짱 떡볶이", "52~62분", 2000))
        tmp.add(RestaurantData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "서울역철도떡볶이 서울역본점", 4.7f, 7000, "철도즉석국물떡볶이, 철도 떡볶이", "52~62분", 3000))

        restaurantRVAdapter = RestaurantRVAdapter(this@RestaurantActivity!!, tmp)
        rv_restaurant_list.apply {
            adapter = restaurantRVAdapter
            layoutManager = LinearLayoutManager(this@RestaurantActivity,LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun selectPage(pageIdx: Int){
        tl_restaurant_menu.isSmoothScrollingEnabled  = true
        tl_restaurant_menu.setScrollPosition(pageIdx, 0f, true)
      var tab : TabLayout.Tab = tl_restaurant_menu.getTabAt(pageIdx) !!
        tab.select()
    }
}
