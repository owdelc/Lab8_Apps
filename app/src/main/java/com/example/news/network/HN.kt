package com.example.news.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HN {
    @GET("/3/movie/popular")
    fun getNews(@Query("api_key") key:String): Call<Datos>
}