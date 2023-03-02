package com.example.rickandmorty.model

import com.example.rickandmorty.listCharacter.data.response.CharacterListResponse
import com.example.rickandmorty.model.response.CharacterDetailResponse
import com.example.rickandmorty.model.retrofit.RetrofitClient
import retrofit2.Response

class CharacterDetailRepository {
    suspend fun getCharacterDetail(id: String): Response<CharacterDetailResponse> {
        return RetrofitClient.getRetrofit().create(CharacterClient::class.java).getCharacterByName(id)
    }
}