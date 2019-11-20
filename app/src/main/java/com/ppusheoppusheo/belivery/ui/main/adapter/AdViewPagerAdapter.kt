package com.ppusheoppusheo.belivery.ui.main.adapter

import com.ppusheoppusheo.belivery.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.asksira.loopingviewpager.LoopingPagerAdapter


class AdViewPagerAdapter(context: Context, itemList: ArrayList<Int>, isInfinite: Boolean) :
    LoopingPagerAdapter<Int>(context, itemList, isInfinite) {

    //This method will be triggered if the item View has not been inflated before.
    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.item_pager_main, container, false)
    }

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        convertView.findViewById<ImageView>(R.id.item_pager_img)
            .setImageResource(getBackgroundColor(listPosition))

        val description = convertView.findViewById<TextView>(R.id.tv_item_pager_ad_num)
        description.text  = itemList[listPosition].toString()
    }

    private fun getBackgroundColor(number: Int): Int {
        when (number) {
            0 -> return R.drawable.ad_img_1
            1 -> return R.drawable.ad_img_1
            2 -> return R.drawable.ad_img_1
            else -> return android.R.color.black
        }
    }
}