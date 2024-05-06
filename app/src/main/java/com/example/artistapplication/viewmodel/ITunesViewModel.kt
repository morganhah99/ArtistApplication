package com.example.artistapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artistapplication.model.ITunesResponseModel
import com.example.artistapplication.repository.ITunesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ITunesViewModel @Inject constructor(private val iTunesRepository: ITunesRepository): ViewModel() {

    val iTunesLiveData = MutableLiveData<ITunesResponseModel>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchITunesResponse() {
        viewModelScope.launch (Dispatchers.IO) {
            val response = iTunesRepository.getResponse()

            if (response.isSuccessful) {
                iTunesLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody().toString())
                Log.i("ITUNES", response.errorBody().toString())
            }

        }
    }

}