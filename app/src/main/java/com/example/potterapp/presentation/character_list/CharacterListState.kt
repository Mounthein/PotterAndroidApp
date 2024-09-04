package com.example.potterapp.presentation.character_list

import com.example.potterapp.domain.model.CharacterSimple

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterSimple> = emptyList(),
    val error: String = ""
)
