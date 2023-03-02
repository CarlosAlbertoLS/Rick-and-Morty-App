package com.example.rickandmorty.model

import com.example.rickandmorty.model.response.CharacterDetailResponse
import com.example.rickandmorty.listCharacter.data.response.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterClient {
    @GET("character")
    suspend fun getCharacter(): Response<CharacterListResponse>

    @GET("character/{name}")
    suspend fun getCharacterByName(@Path("name") name: String): Response<CharacterDetailResponse>
}