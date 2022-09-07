package com.example.retrofit_with_coroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.model.RecyclerviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecyclerviewViewModel @Inject constructor():ViewModel() {

    @Inject lateinit var recyclerviewRepository:RecyclerviewRepository

    private val _imagesList = MutableLiveData<MutableList<Posts>?>()
    val imagesList get() = _imagesList
    init {
        viewModelScope.launch {
            _imagesList.value = getImagesFromRepository()
        }
    }

   suspend fun getImagesFromRepository():MutableList<Posts>{
       return recyclerviewRepository.getImagesListFromRemote()
    }
}