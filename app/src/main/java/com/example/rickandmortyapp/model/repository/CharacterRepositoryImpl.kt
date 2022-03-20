package com.example.rickandmortyapp.model.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.rickandmortyapp.CharacterQuery
import com.example.rickandmortyapp.CharactersListQuery
import com.example.rickandmortyapp.model.networking.RickAndMortyApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val webService: RickAndMortyApi
) : CharacterRepository {
    override suspend fun queryCharactersList(): Response<CharactersListQuery.Data> {
        return webService.getApolloClient().query(CharactersListQuery()).await()
    }

    override suspend fun queryCharacter(id: String): Response<CharacterQuery.Data> {
        return webService.getApolloClient().query(CharacterQuery(id)).await()
    }
}