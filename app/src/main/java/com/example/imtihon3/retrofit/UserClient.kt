package com.example.mycontactretrofit.retrofit

import com.example.imtihon3.retrofit.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()

    val userApi: UserApi = retrofit.create(UserApi::class.java)

}