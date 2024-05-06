package com.example.artistapplication.repository

import com.example.artistapplication.network.ITunesAPIService
import javax.inject.Inject

class ITunesRepository @Inject constructor(private val service: ITunesAPIService) {

    suspend fun getResponse() = service.getResponse()
}