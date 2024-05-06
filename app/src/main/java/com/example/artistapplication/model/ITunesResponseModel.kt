package com.example.artistapplication.model


import com.google.gson.annotations.SerializedName

data class ITunesResponseModel(
    @SerializedName("resultCount")
    val resultCount: Int? = 0,
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)