package com.example.motive.search.di

import com.example.motive.search.data.SearchDataSource
import com.example.motive.search.data.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideRepository(searchRepository: SearchRepository): SearchDataSource = searchRepository
}

