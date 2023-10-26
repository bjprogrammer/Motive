package com.example.motive.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.example.motive.network.service.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideGsonInstance(): Gson = GsonBuilder()
        .create()

    @Provides
    fun provideGSONConverterFactory(
        gson: Gson
    ): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    @BaseUrlQualifier
    fun provideBaseUrl() = BASEURL

    @Provides
    fun provideRetrofitInstance(
        converterFactory: Converter.Factory,
        @BaseUrlQualifier baseUrl:String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(converterFactory)
        .baseUrl(baseUrl)
        .build()

    @Singleton
    @Provides
    fun provideHoldingApiService(retrofit: Retrofit): NetworkService = retrofit.create(
        NetworkService::class.java)

    companion object {
        const val BASEURL = "https://secure.geonames.org/"
    }
}

