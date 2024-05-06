package com.example.artistapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artistapplication.model.ResultModel
import com.example.artistapplication.repository.ITunesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ITunesViewModel @Inject constructor(private val iTunesRepository: ITunesRepository): ViewModel() {

    val iTunesLiveData = MutableLiveData<List<ResultModel>>()

    fun fetchITunesResponse() {
        viewModelScope.launch (Dispatchers.IO) {
            val response = iTunesRepository.getResponse()

            if (response.isSuccessful && response.body() != null) {
                val results = response.body()?.results ?: emptyList()
                iTunesLiveData.postValue(results.filterNotNull())
            }

        }
    }

}