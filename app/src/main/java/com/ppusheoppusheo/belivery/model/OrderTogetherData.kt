package com.ppusheoppusheo.belivery.model

data class OrderTogetherData (
    val food_img: String,
    val restaurant_name : String,
    var rest_min: Int,
    var rest_sec: Int,
    var rest_price: Int
)