package com.example.imtihon3.retrofit

import com.example.imtihon3.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @GET("users")
    fun getUsers(): Call<List<UserModel>>

}