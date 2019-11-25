package com.ppusheoppusheo.belivery.util

import com.ppusheoppusheo.belivery.model.GetFoodCategoryResponse
import com.ppusheoppusheo.belivery.model.GetOrderTogetherResponse
import com.ppusheoppusheo.belivery.model.RestaurantData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    // 메인
    @GET("/orderWith/list")
    fun getOrderTogetherResponse(
    ): Call<GetOrderTogetherResponse>

    //식당
    @GET("/store/list/{foodCategory}")
    fun getFoodCategoryResponse(
        @Path("foodCategory")foodCategory:Int
    ):Call<GetFoodCategoryResponse>
}