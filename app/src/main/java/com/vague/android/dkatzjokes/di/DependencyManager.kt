package com.vague.android.dkatzjokes.di

import com.vague.android.dkatzjokes.data.DefaultRepository
import com.vague.android.dkatzjokes.data.source.local.FakeLocalDataSource
import com.vague.android.dkatzjokes.data.source.remote.DefaultRemoteDataSource
import com.vague.android.dkatzjokes.ui.home.HomeFragmentViewModelFactory

object DependencyManager {

    fun provideLocalDataSource() = FakeLocalDataSource()
    fun provideRemoteDataSource() = DefaultRemoteDataSource()

    fun provideRepository() = DefaultRepository(provideLocalDataSource(), provideRemoteDataSource())

    fun provideHomeFragmentViewModelFactory() = HomeFragmentViewModelFactory(provideRepository())
}