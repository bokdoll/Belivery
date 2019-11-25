package com.ppusheoppusheo.belivery.model

data class GetFoodCategoryResponse(
    val  message: ArrayList<RestaurantData>
)

data class RestaurantData (
    val restaurant_img: String,
    val restaurant_name: String,
    val star_rate: Float,
    val min_price: Int,
    val main_menu: String,
    val delivery_time: String,
    val delivery_tip: Int
)