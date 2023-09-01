package com.example.sathasdroid.APIService

import com.example.sathasdroid.Entity.Holiday
import retrofit2.Call
import retrofit2.http.GET

interface HolidayService {
    @GET("/api/v2/publicholidays/2023/us")
    fun getHolidayDetails():Call<List<Holiday>>

}