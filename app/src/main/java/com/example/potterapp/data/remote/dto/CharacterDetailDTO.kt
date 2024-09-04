package com.example.potterapp.data.remote.dto

import com.example.potterapp.domain.model.CharacterDetail
import com.example.potterapp.domain.model.CharacterSimple

data class CharacterDetailDTO(
    val actor: String,
    val alive: Boolean,
    val alternate_actors: List<String>,
    val alternate_names: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wandDTO: WandDTO,
    val wizard: Boolean,
    val yearOfBirth: Int
)

fun CharacterDetailDTO.toCharacterSimple(): CharacterSimple {
    return CharacterSimple(
      characterId = id,
        name = name,
        alive = alive,
        gender = gender,
        species = species
    )
}