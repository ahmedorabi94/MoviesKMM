package com.example.movieskmm.domain.model.get_movie

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailResponse(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    // val belongs_to_collection: BelongsToCollection,
    val budget: Int = 0,
    val genres: List<Genre>? = null,
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    //  val production_companies: List<ProductionCompany>,
    //  val production_countries: List<ProductionCountry>,
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    // val spoken_languages: List<SpokenLanguage>,
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)