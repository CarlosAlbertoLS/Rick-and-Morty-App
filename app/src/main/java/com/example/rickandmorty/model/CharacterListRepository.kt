package com.example.rickandmorty.model

import com.example.rickandmorty.listCharacter.data.response.CharacterListResponse
import com.example.rickandmorty.model.retrofit.RetrofitClient
import retrofit2.Response

class CharacterListRepository {
    suspend fun getCharacterList(): Response<CharacterListResponse> {
        return RetrofitClient.getRetrofit().create(CharacterClient::class.java).getCharacter()
    }
}