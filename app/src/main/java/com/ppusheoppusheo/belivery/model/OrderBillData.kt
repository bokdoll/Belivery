package com.ppusheoppusheo.belivery.model

data class OrderBillData (
    var restaurant_name: String,
    var menu: String,
    var min_price: String,
    var current_price: String,
    var delivery_tip: String
)