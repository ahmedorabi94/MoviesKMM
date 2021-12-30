package com.example.movieskmm.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
 //   val id : Long,
    val dates: Dates? =null,
    val page: Long,
    val results: List<Movie>,
    val total_pages: Long,
    val total_results: Long
)