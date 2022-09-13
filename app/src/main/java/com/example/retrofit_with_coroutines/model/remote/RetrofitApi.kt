package com.example.retrofit_with_coroutines.model.remote

import com.example.retrofit_with_coroutines.data.Posts
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

val RetrofitInstance = retrofit.create(RetrofitApi::class.java)

interface RetrofitApi{

    @GET("photos")
    suspend fun getPhotosList():MutableList<Posts>
}

