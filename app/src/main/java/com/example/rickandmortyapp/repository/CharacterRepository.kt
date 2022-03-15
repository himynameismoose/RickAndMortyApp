package com.example.rickandmortyapp.repository

import com.apollographql.apollo.api.Response
import com.example.rickandmortyapp.CharactersListQuery

interface CharacterRepository {

    suspend fun queryCharactersList(): Response<CharactersListQuery.Data>
}