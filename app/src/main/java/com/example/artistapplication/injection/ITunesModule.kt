package com.example.artistapplication.injection

import com.example.artistapplication.network.ITunesAPIService
import com.example.artistapplication.repository.ITunesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ITunesModule {

    @Singleton
    @Provides
    fun provideAPIServiceObject(): ITunesAPIService =
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ITunesAPIService::class.java)

    @Singleton
    @Provides
    fun provideITunesRepo(): ITunesRepository =
        ITunesRepository(provideAPIServiceObject())
}