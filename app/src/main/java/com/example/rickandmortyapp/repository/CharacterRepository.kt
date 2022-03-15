package com.example.rickandmortyapp.repository

import com.apollographql.apollo.api.Response
import com.example.rickandmortyapp.CharacterQuery
import com.example.rickandmortyapp.CharactersListQuery

interface CharacterRepository {

    // generates character list
    suspend fun queryCharactersList(): Response<CharactersListQuery.Data>

    // generates character
    suspend fun queryCharacter(id: String): Response<CharacterQuery.Data>
}