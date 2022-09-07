package com.example.retrofit_with_coroutines.model.remote

import com.example.retrofit_with_coroutines.data.Posts
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRemoteSource @Inject constructor() {

    fun getImagesFromRemote():MutableList<Posts>{
        return emptyList<Posts>().toMutableList()
    }
}