package com.seonghyeon.android.airbnb

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/56e7566c-5763-4fe9-9b03-947c32d38775")
    fun getHouseList(): Call<HouseDto>
}