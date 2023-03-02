package com.example.rickandmorty.domain

import com.example.rickandmorty.model.CharacterDetailRepository
import com.example.rickandmorty.model.response.CharacterDetailResponse
import retrofit2.Response

class GetCharacterDetailUseCase(private val repository: CharacterDetailRepository) {
    suspend operator fun invoke(id: String): Response<CharacterDetailResponse> {
        return repository.getCharacterDetail(id)
    }
}