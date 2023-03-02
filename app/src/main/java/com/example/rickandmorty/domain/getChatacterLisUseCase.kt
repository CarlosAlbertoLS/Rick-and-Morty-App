package com.example.rickandmorty.domain

import com.example.rickandmorty.listCharacter.data.response.CharacterListResponse
import com.example.rickandmorty.model.CharacterListRepository
import retrofit2.Response

class GetCharacterListUseCase(private val repository: CharacterListRepository) {
    suspend operator fun invoke(): Response<CharacterListResponse> {
        return repository.getCharacterList()
    }
}