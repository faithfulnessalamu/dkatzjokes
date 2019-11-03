package com.vague.android.dkatzjokes.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.databinding.AltLayoutJokeItemBinding

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
        val inflater = LayoutInflater.from(parent.context)
        val binding = AltLayoutJokeItemBinding.inflate(inflater, parent, false)

        return HomeFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeFragmentViewHolder(private val binding: AltLayoutJokeItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(joke: Joke) {
        binding.apply {
            txtJokeSetup.text = joke.setup
            txtJokePunchline.text = joke.punchline
            chipJokeType.text = joke.type
        }
    }
}