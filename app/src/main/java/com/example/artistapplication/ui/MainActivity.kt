package com.example.artistapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artistapplication.databinding.ActivityMainBinding
import com.example.artistapplication.viewmodel.ITunesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ITunesViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchITunesResponse()

        viewModel.iTunesLiveData.observe(this) {
            Log.i("ITUNES RESPONSE", it.toString())

            binding.rvITunesTracks.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ITunesAdapter(it)
            }

        }

    }
}