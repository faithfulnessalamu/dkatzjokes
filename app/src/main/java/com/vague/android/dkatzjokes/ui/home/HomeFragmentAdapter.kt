package com.vague.android.dkatzjokes.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.vague.android.dkatzjokes.R
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
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.layout_joke_item, parent, false)
        return HomeFragmentViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeFragmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val txtJokeSetup = view.findViewById<TextView>(R.id.txt_joke_setup)
    val txtJokePunchline = view.findViewById<TextView>(R.id.txt_joke_punchline)
    val txtJokeType = view.findViewById<Chip>(R.id.chip_joke_type)

    fun bind(joke: Joke) {
        txtJokeSetup.text = joke.setup
        txtJokePunchline.text = joke.punchline
        txtJokeType.text = joke.type
    }
}