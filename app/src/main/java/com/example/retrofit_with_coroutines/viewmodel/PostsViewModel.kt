package com.example.retrofit_with_coroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.model.RecyclerviewRepository
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel() {

 var recyclerviewRepository:RecyclerviewRepository = RecyclerviewRepository()

    private val _imagesList = MutableLiveData<MutableList<Posts>?>()
    val imagesList:LiveData<MutableList<Posts>?> get() = _imagesList
    private val _currentPost:MutableLiveData<Posts> = MutableLiveData<Posts>()
    val currentPost:LiveData<Posts> get() = _currentPost


    init {
        viewModelScope.launch {
            _imagesList.value = getImagesFromRepository()
        }
    }

   suspend fun getImagesFromRepository():MutableList<Posts>{
       return recyclerviewRepository.getImagesListFromRemote()
    }

    fun setCurrentPost(it: Posts) {
        _currentPost.value = it
    }
}