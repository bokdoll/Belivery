package com.ppusheoppusheo.belivery.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.model.OrderTogetherData

class OrderTogetherRVAdapter(private val ctx: Context, var dataList: List<OrderTogetherData>):
        RecyclerView.Adapter<OrderTogetherRVAdapter.Holder>(){
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_together_order, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int  = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        dataList[position].let{ item ->
            Glide.with(ctx)
                .load(item.food_img)
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivFood)

            holder.tvRestaurantName.text = item.restaurant_name
            holder.tvMin.text = item.rest_min.toString()
            holder.tvSec.text = item.rest_sec.toString()
            holder.tvPrice.text = item.rest_price.toString()
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivFood : ImageView =  itemView.findViewById(R.id.iv_rv_item_main_together_food)
        val tvRestaurantName : TextView = itemView.findViewById(R.id.tv_rv_item_main_together_restaurant_name)
        val tvMin : TextView = itemView.findViewById(R.id.tv_rv_item_main_together_min)
        val tvSec : TextView = itemView.findViewById(R.id.tv_rv_item_main_together_sec)
        val tvPrice : TextView = itemView.findViewById(R.id.tv_rv_item_main_together_price)
    }
}