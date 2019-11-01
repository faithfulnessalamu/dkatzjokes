package com.vague.android.dkatzjokes.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vague.android.dkatzjokes.data.model.Joke

class HomeFragmentAdapter : ListAdapter<Joke, HomeFragmentViewHolder>(
    object : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewHolder {

    }

    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {
        holder.bind()
    }
}

class HomeFragmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind() {}
}