package com.ppusheoppusheo.belivery.ui.fastorder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.ppusheoppusheo.belivery.R
import kotlinx.android.synthetic.main.activity_fast_order.*


class FastOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fast_order)

        initView()
    }

    private fun initView() {
        setTabLayout()

        btn_order_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.sliding_down, R.anim.stay);
        }
    }


    private fun setTabLayout() {

        vp_order_pager.apply{
            adapter = FastOrderTabFragmentStatePager(supportFragmentManager, 12)
            offscreenPageLimit = 12
        }

        tl_order_menu.setupWithViewPager(vp_order_pager, true)

        val tabLayout: View = this.layoutInflater.inflate(R.layout.tab_order_menu, null, false)

        val tl_menu = findViewById<TabLayout>(R.id.tl_order_menu)

        tl_menu!!.getTabAt(0)!!.customView = tabLayout.findViewById(R.id.btn_order_chicken)
        tl_menu.getTabAt(1)!!.customView = tabLayout.findViewById(R.id.btn_order_raw_fish)
        tl_menu.getTabAt(2)!!.customView = tabLayout.findViewById(R.id.btn_order_snack)
        tl_menu.getTabAt(3)!!.customView = tabLayout.findViewById(R.id.btn_order_pizza)
        tl_menu.getTabAt(4)!!.customView = tabLayout.findViewById(R.id.btn_order_night)
        tl_menu.getTabAt(5)!!.customView = tabLayout.findViewById(R.id.btn_order_japanese)
        tl_menu.getTabAt(6)!!.customView = tabLayout.findViewById(R.id.btn_order_korean)
        tl_menu.getTabAt(7)!!.customView = tabLayout.findViewById(R.id.btn_order_chinese)
        tl_menu.getTabAt(8)!!.customView = tabLayout.findViewById(R.id.btn_order_pork)
        tl_menu.getTabAt(9)!!.customView = tabLayout.findViewById(R.id.btn_order_zzim)
        tl_menu.getTabAt(10)!!.customView = tabLayout.findViewById(R.id.btn_order_dosirak)
        tl_menu.getTabAt(11)!!.customView = tabLayout.findViewById(R.id.btn_order_dessert)
    }


}