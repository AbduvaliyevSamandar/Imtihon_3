package com.example.imtihon3.retrofit

import com.example.imtihon3.modelpost.PostModel
import com.example.imtihon3.models.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface postApi {

    @GET("posts")
    fun getpost(@Query("id")id:Int): Call<List<PostModel>>
}