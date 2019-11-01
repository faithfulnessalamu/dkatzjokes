package com.vague.android.dkatzjokes.ui.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.ui.home.HomeFragmentAdapter

@BindingAdapter("app:dataset")
fun setRecyclerViewDataset(recyclerView: RecyclerView, dataset: List<Joke>) {
    (recyclerView.adapter as HomeFragmentAdapter)
        .submitList(dataset)
}