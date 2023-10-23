package com.example.imtihon3.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()

    val postapi: postApi = retrofit.create(postApi::class.java)
}