package com.example.rickandmortyapp.presenter

import com.example.rickandmortyapp.model.networking.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Singleton
    @Provides
    fun provideWebService() = RickAndMortyApi()
}