package com.example.potterapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WandDTO(
    val core: String,
    val length: Int,
    val wood: String
)