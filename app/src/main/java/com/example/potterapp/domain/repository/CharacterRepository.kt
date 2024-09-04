package com.example.potterapp.domain.repository

import com.example.potterapp.data.remote.dto.CharacterDetailDTO
import com.example.potterapp.domain.model.CharacterSimple

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterSimple>

    suspend fun getCharacter(): List<CharacterDetailDTO>
}