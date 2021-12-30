package com.example.movieskmm.domain.model.get_movie

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Int,
    val name: String
)