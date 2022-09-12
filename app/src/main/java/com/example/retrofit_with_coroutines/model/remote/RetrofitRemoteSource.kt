package com.example.retrofit_with_coroutines.model.remote

import android.util.Log
import com.example.retrofit_with_coroutines.data.Posts
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "RetrofitRemoteSource"
class RetrofitRemoteSource () {

   suspend fun getImagesFromRemote():MutableList<Posts>{
       return try {
           val data = RetrofitInstance.getPhotosList()
           Log.d(TAG, "data = $data")
           return data
       }catch (e:java.lang.Exception){
           e.printStackTrace()
           Log.d(TAG,"exception in getting msg = ${e.message}")
           emptyList<Posts>().toMutableList()
       }
    }
}