package com.example.retrofit_with_coroutines.model

import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.model.remote.RetrofitRemoteSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecyclerviewRepository @Inject constructor() {

    @Inject lateinit var remoteDataSource:RetrofitRemoteSource

    suspend fun getImagesListFromRemote():MutableList<Posts>{
        return remoteDataSource.getImagesFromRemote()
    }
}