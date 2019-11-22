package com.ppusheoppusheo.belivery.util

import com.ppusheoppusheo.belivery.model.GetOrderTogetherResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    // 메인
    @GET("/orderWith/list")
    fun getOrderTogetherResponse(
    ): Call<GetOrderTogetherResponse>
}