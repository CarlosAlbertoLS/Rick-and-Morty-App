package com.example.rickandmorty.ui.detailCharacter.characterDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.GetCharacterDetailUseCase
import com.example.rickandmorty.model.CharacterDetailRepository
import com.example.rickandmorty.model.response.CharacterDetailResponse
import kotlinx.coroutines.launch

class CharacterDetailViewModel: ViewModel() {
    private val getCharacterDetailUseCase = GetCharacterDetailUseCase(CharacterDetailRepository())
    val detailCharacter: MutableLiveData<CharacterDetailResponse> = MutableLiveData()

    fun characterDetailData(id: String){
        viewModelScope.launch {
            val myResponse = getCharacterDetailUseCase.invoke(id)
            val response = myResponse.body()
            if (response != null){
                detailCharacter.value = CharacterDetailResponse(
                    name = response.name,
                    image = response.image,
                    status = response.status,
                    species = response.species,
                    gender = response.gender,
                    type = response.type
                )
            }
        }
    }
}