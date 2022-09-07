package com.example.retrofit_with_coroutines.di

import com.example.retrofit_with_coroutines.model.RecyclerviewRepository
import com.example.retrofit_with_coroutines.model.remote.RetrofitRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ActivityModelDI {


    @Provides
    @Singleton
    fun ProvideRepository():RecyclerviewRepository{
        return RecyclerviewRepository()
    }


    @Singleton
    @Provides
    fun ProvideRemoteDataSource():RetrofitRemoteSource{
        return RetrofitRemoteSource()
    }
}