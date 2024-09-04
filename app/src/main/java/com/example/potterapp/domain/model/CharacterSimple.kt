package com.example.potterapp.domain.model

data class CharacterSimple(
    val characterId: String,
    val name: String,
    val alive: Boolean,
    val gender: String,
    val species: String
)
