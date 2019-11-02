package com.vague.android.dkatzjokes.ui.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.vague.android.dkatzjokes.data.model.Joke
import com.vague.android.dkatzjokes.ui.home.HomeFragmentAdapter

@BindingAdapter("app:dataset")
fun setRecyclerViewDataset(recyclerView: RecyclerView, dataset: List<Joke>) {
    (recyclerView.adapter as HomeFragmentAdapter)
        .submitList(dataset)
}

@BindingAdapter("app:isRefreshing")
fun swiperIsRefreshing(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean) {
    swipeRefreshLayout.isRefreshing = isRefreshing
}

@BindingAdapter("app:onRefresh")
fun swiperOnRefresh(swipeRefreshLayout: SwipeRefreshLayout, onRefresh: () -> Unit) {
    swipeRefreshLayout.setOnRefreshListener {
        onRefresh.invoke()
    }
}