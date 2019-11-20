package com.ppusheoppusheo.belivery.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.asksira.loopingviewpager.LoopingViewPager
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.OrderTogetherData
import com.ppusheoppusheo.belivery.ui.MapActivity
import com.ppusheoppusheo.belivery.ui.main.adapter.AdViewPagerAdapter
import com.ppusheoppusheo.belivery.ui.main.adapter.OrderTogetherRVAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var orderTogetherRVAdapter: OrderTogetherRVAdapter
    lateinit var adapter : AdViewPagerAdapter
    lateinit var viewPager : LoopingViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_map.setOnClickListener{
            val intent = Intent(this@MainActivity, MapActivity::class.java)
            startActivity(intent)
        }

        getOrderTogetherFoodRequest()
        //btn_main_timer.setOnClickListener {
        //    runTimer()
        //}

        viewPager = findViewById(R.id.vp_main_ad)

        try {
            adapter = AdViewPagerAdapter(this@MainActivity, createSecondDummyItems(), true)
            viewPager.setAdapter(adapter)
        }catch (e: Exception){
            Log.e("현주", e.message.toString())
        }
    }

    private fun createSecondDummyItems(): java.util.ArrayList<Int> {
        val items = java.util.ArrayList<Int>()
        items.add(0, 1)
        items.add(1, 2)
        items.add(2, 3)
        return items
    }

    override fun onResume() {
        super.onResume()
        viewPager.resumeAutoScroll()
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


//    fun runTimer(){
//        var time: Int = 3
//        // 1분마다
//        timer(period = 60000){
//            runOnUiThread {
//                time--
//                tv_main_time_min.text = "$time"
//            }
//        }
//    }
}

