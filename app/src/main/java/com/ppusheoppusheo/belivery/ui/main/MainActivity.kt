package com.ppusheoppusheo.belivery.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.asksira.loopingviewpager.LoopingViewPager
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.OrderTogetherData
<<<<<<< HEAD
=======
import com.ppusheoppusheo.belivery.ui.MyPageActivity
import com.ppusheoppusheo.belivery.ui.map.MapActivity
>>>>>>> 9e454b1fb16a6aad520d1b6f70c7cc154a5af258
import com.ppusheoppusheo.belivery.ui.fastorder.FastOrderActivity
import com.ppusheoppusheo.belivery.ui.main.adapter.AdViewPagerAdapter
import com.ppusheoppusheo.belivery.ui.main.adapter.OrderTogetherRVAdapter
import com.ppusheoppusheo.belivery.ui.map.MapActivity
import com.ppusheoppusheo.belivery.ui.restaurant.RestaurantActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var orderTogetherRVAdapter: OrderTogetherRVAdapter
    lateinit var adapter : AdViewPagerAdapter
    lateinit var viewPager : LoopingViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    override fun onResume() {
        super.onResume()
        viewPager.resumeAutoScroll()
    }


    private fun initView(){

        //같이 시키리 서버 통신
        getOrderTogetherFoodRequest()

        // 광고 뷰페이저 설정
        displayAd()

        //맵 액티비티 띄우기
        btn_main_map.setOnClickListener{
            val intent = Intent(this@MainActivity, MapActivity::class.java)
            startActivity(intent)
        }

        btn_main_order.setOnClickListener {
            val intent = Intent(this@MainActivity, FastOrderActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.sliding_up, R.anim.stay)
        }

        //식당 액티비티 띄우기
        btn_main_alone_chicken.setOnClickListener { startRestaurantActivity(0)}
        btn_main_alone_raw_fish.setOnClickListener { startRestaurantActivity(1)}
        btn_main_alone_snack.setOnClickListener { startRestaurantActivity(2)}
        btn_main_alone_pizza.setOnClickListener { startRestaurantActivity(3)}
        btn_main_alone_night.setOnClickListener { startRestaurantActivity(4)}
        btn_main_alone_japanese.setOnClickListener { startRestaurantActivity(5)}
        btn_main_alone_korean.setOnClickListener { startRestaurantActivity(6)}
        btn_main_alone_chinese.setOnClickListener { startRestaurantActivity(7)}
        btn_main_alone_pork.setOnClickListener { startRestaurantActivity(8)}
        btn_main_alone_zzim.setOnClickListener { startRestaurantActivity(9)}
        btn_main_alone_dosirak.setOnClickListener { startRestaurantActivity(10)}
        btn_main_alone_dessert.setOnClickListener { startRestaurantActivity(11)}

        btn_main_mypage.setOnClickListener{
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
    }

    //식당 액티비티 띄우기
    fun startRestaurantActivity(menu_num: Int){
        val intent = Intent(this@MainActivity, RestaurantActivity::class.java)
        intent.putExtra("menu_num", menu_num)
        startActivity(intent)
    }

    // 광고 뷰페이저 설정
    private fun displayAd(){
        viewPager = findViewById(R.id.vp_main_ad)

        try {
            adapter = AdViewPagerAdapter(this@MainActivity, createDummyItems(), true)
            viewPager.setAdapter(adapter)
        }catch (e: Exception){
            Log.e("현주", e.message.toString())
        }
    }

    private fun createDummyItems(): java.util.ArrayList<Int> {
        val items = java.util.ArrayList<Int>()
        items.add(0, 1)
        items.add(1, 2)
        items.add(2, 3)
        return items
    }


    //같이 시키리 서버 통신
    private fun getOrderTogetherFoodRequest(){
        var tmp : ArrayList<OrderTogetherData> = ArrayList<OrderTogetherData>()

        tmp.add(OrderTogetherData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "옐로우 피자 용산점", 7, 46, 7500))
        tmp.add(OrderTogetherData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "BHC 공덕점", 7, 46, 7500))
        tmp.add(OrderTogetherData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "옐로우 피자 용산점", 7, 46, 7500))
        tmp.add(OrderTogetherData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "옐로우 피자 용산점", 7, 46, 7500))
        tmp.add(OrderTogetherData("https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png", "옐로우 피자 용산점", 7, 46, 7500))

        orderTogetherRVAdapter = OrderTogetherRVAdapter(this@MainActivity!!, tmp)
        rv_main_order_together_restaurant_list.apply {
            adapter = orderTogetherRVAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL, false)
        }
    }
}

