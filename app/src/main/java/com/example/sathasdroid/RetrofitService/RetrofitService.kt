package com.example.sathasdroid.RetrofitService

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* The Class Is Used For Building Retrofit API Client
* */
class RetrofitService {
    private var retrofit: Retrofit

    init {
        this.retrofit = initRetrofit()
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://date.nager.at")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    fun getRetrofit():Retrofit{
        return retrofit
    }
}