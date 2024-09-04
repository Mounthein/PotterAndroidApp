package com.example.potterapp.domain.model

import com.example.potterapp.data.remote.dto.WandDTO

data class CharacterDetail(
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
    val characterId: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wandDTO: WandDTO,
    val wizard: Boolean,
    val yearOfBirth: Int
)
