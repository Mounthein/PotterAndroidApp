package com.example.potterapp.data.repository

import com.example.potterapp.data.remote.PotterApi
import com.example.potterapp.data.remote.dto.CharacterDetailDTO
import com.example.potterapp.data.remote.dto.toCharacterSimple
import com.example.potterapp.domain.model.CharacterSimple
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: PotterApi
): PotterApi {
    override suspend fun getCharacters(): List<CharacterDetailDTO> {
        return api.getCharacters()
    }

    override suspend fun getCharacter(id: String): CharacterDetailDTO {
        return api.getCharacter(id)
    }

    suspend fun getSimpleCharacters(): List<CharacterSimple> {
        return getCharacters().map { it.toCharacterSimple() }
    }

}