package com.example.artistapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artistapplication.R
import com.example.artistapplication.databinding.ItemItunesTrackBinding
import com.example.artistapplication.model.ResultModel

class ITunesAdapter(
    val trackList: List<ResultModel>
) : RecyclerView.Adapter<ITunesAdapter.ITunesViewHolder>(){

    inner class ITunesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemItunesTrackBinding.bind(itemView)
        fun updateUI(iTunesItemModel: ResultModel){
            binding.apply {
                Glide.with(itemView.context)
                    .load(iTunesItemModel.artworkUrl60)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(ivCover)
                tvTitle.text = iTunesItemModel.trackName
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ITunesViewHolder {

        return ITunesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_itunes_track, parent, false)
        )

    }

    override fun getItemCount() = trackList.size

    override fun onBindViewHolder(holder: ITunesViewHolder, position: Int) {
        holder.updateUI(trackList[position])
    }
}