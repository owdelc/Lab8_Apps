package com.example.news.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.AbstractExecutorService

object Cons {

    private val cliente = OkHttpClient.Builder().build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://hn.algolia.com/api/v1/search?query=")
        .addConverterFactory(GsonConverterFactory.create())
        .client(cliente)

    fun<T> construir(servicio: Class<T>): T{
        return retrofit.create(servicio)
    }


}