package com.vague.android.dkatzjokes.di

import android.content.Context
import com.vague.android.dkatzjokes.data.DefaultRepository
import com.vague.android.dkatzjokes.data.source.local.DefaultLocalDataSource
import com.vague.android.dkatzjokes.data.source.local.LocalDatabase
import com.vague.android.dkatzjokes.data.source.remote.DefaultRemoteDataSource
import com.vague.android.dkatzjokes.ui.home.HomeFragmentViewModelFactory

object DependencyManager {

    private fun provideLocalDatabase(context: Context): LocalDatabase {
        return LocalDatabase.getInstance(context.applicationContext)
    }

    fun provideLocalDataSource(context: Context) = DefaultLocalDataSource(provideLocalDatabase(context).jokesDao)
    fun provideRemoteDataSource() = DefaultRemoteDataSource()

    fun provideRepository(context: Context) =
        DefaultRepository(provideLocalDataSource(context), provideRemoteDataSource())

    fun provideHomeFragmentViewModelFactory(context: Context) = HomeFragmentViewModelFactory(provideRepository(context))
}