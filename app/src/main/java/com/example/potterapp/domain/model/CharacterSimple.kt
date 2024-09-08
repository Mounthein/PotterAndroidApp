package com.example.potterapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterSimple(
    val characterId: String,
    val name: String,
    val alive: Boolean,
    val gender: String,
    val species: String
)
