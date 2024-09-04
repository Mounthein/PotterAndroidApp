package com.example.potterapp.presentation.character_detail

import com.example.potterapp.data.remote.dto.CharacterDetailDTO

class CharacterState (
    val isLoading: Boolean = false,
    val character: CharacterDetailDTO? = null,
    val error: String = ""
)