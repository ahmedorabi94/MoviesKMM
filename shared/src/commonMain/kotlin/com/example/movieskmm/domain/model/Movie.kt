package com.example.movieskmm.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(

    val first_air_date: String = "",
    val name: String = "",
    val original_name: String = "",
    val origin_country: List<String>? = null,

    val media_type: String = "",
    val author: String = "",
    val content: String = "",
    val url: String = "",

    val adult: Boolean = false,
    val backdrop_path: String = "",

    val genre_ids: List<Long>? = null,
    val id: Int = 0,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Long = 0,

    )