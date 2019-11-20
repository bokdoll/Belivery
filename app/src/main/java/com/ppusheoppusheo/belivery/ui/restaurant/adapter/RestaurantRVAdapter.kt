package com.ppusheoppusheo.belivery.ui.restaurant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.RestaurantData

class RestaurantRVAdapter (private val ctx: Context, var dataList: List<RestaurantData>)
    : RecyclerView.Adapter<RestaurantRVAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantRVAdapter.Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_restaurant, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RestaurantRVAdapter.Holder, position: Int) {
        dataList[position].let {item->
            Glide.with(ctx)
                .load(item.restaurant_img)
                .transforms(CenterCrop(), RoundedCorners(dp2px(ctx, 38)))
                .into(holder.ivRestaurant)

            holder.tvRestaurant.text = item.restaurant_name
            holder.tvStarRate.text = item.star_rate.toString()
            holder.tvMinPrice.text = addComma(item.min_price.toString())
            holder.tvMainMenu.text = item.main_menu
            holder.tvDeliveryTime.text = item.delivery_time
            holder.tvDeliveryTip.text = addComma(item.delivery_tip.toString())
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivRestaurant : ImageView = itemView.findViewById(R.id.iv_rv_item_restaurant_img)
        val tvRestaurant : TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_name)
        val tvStarRate: TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_star_rate)
        val tvMinPrice: TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_min_price)
        val tvMainMenu: TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_menu)
        val tvDeliveryTime: TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_time)
        val tvDeliveryTip: TextView = itemView.findViewById(R.id.tv_rv_item_restaurant_tip)
    }

    // dp를 픽셀으로 단위 변환
    fun dp2px(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    // 가격에 콤마 더하고 원 붙이기
    fun addComma(num: String): String{
        var start: String = num.substring(0, num.length-3)
        var end: String = num.substring(num.length-3, num.length)
        return start+end+"원"
    }
}