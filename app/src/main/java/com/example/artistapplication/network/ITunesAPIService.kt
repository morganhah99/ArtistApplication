package com.example.artistapplication.network

import com.example.artistapplication.model.ITunesResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ITunesAPIService {

    @GET("search?term=classick&media=music&entity=song&limit=50")
    suspend fun getResponse(): Response<ITunesResponseModel>
}