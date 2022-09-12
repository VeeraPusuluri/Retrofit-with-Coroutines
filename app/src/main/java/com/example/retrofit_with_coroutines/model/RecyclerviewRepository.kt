package com.example.retrofit_with_coroutines.model

import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.model.remote.RetrofitRemoteSource
import javax.inject.Inject
import javax.inject.Singleton

class RecyclerviewRepository() {

    val remoteDataSource:RetrofitRemoteSource = RetrofitRemoteSource()

    suspend fun getImagesListFromRemote():MutableList<Posts>{
        return remoteDataSource.getImagesFromRemote()
    }
}