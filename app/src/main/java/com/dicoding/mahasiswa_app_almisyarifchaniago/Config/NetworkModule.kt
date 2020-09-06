package com.dicoding.mahasiswa_app_almisyarifchaniago.Config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    //running di hp da ?
    //da ?


    fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.43.168/mentoring_kotlin_week4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service() : ApiService = getRetrofit().create(ApiService::class.java)
}