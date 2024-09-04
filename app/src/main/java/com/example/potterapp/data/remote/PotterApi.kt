package com.example.potterapp.data.remote

import com.example.potterapp.data.remote.dto.CharacterDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PotterApi {
    @GET("api/characters")
    suspend fun getCharacters() : List<CharacterDetailDTO>

    @GET("api/character/{characterId}")
    suspend fun getCharacter(@Path("characterId")id: String): CharacterDetailDTO
}
