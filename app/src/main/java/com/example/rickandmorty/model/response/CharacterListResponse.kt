package com.example.rickandmorty.listCharacter.data.response

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("results") val results : List<Characters>
)

data class Characters(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("id") val id: String,
)
