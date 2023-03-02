package com.example.rickandmorty.model.response

import com.google.gson.annotations.SerializedName

data class CharacterDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("type") val type: String?,
)
