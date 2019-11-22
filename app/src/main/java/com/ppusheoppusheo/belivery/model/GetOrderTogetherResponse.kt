package com.ppusheoppusheo.belivery.model

import com.google.gson.annotations.SerializedName

data class GetOrderTogetherResponse(
    val status: Int,
    val data: OrderTogetherNumData
)

data class OrderTogetherNumData(
    val num: Int,
    val list: ArrayList<OrderTogetherData>
)

data class OrderTogetherData (
    @SerializedName("store_img")
    val food_img: String,
    @SerializedName("store_name")
    val restaurant_name : String,
    @SerializedName("store_min")
    var rest_min: Int,
    @SerializedName("store_sec")
    var rest_sec: Double,
    @SerializedName("order_price")
    var rest_price: Int
)