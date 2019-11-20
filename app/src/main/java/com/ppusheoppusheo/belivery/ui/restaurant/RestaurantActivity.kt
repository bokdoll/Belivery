package com.ppusheoppusheo.belivery.ui.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.RestaurantData
import com.ppusheoppusheo.belivery.ui.restaurant.adapter.RestaurantRVAdapter
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity() {

    lateinit var restaurantRVAdapter: RestaurantRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        getRestaurantResponse()

        cl_restaurant_top.setOnClickListener{
            finish()
        }
    }

    // 식당 서버 통신
    fun getRestaurantResponse(){
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
}
