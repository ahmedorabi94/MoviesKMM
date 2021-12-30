package com.example.movieskmm.presentation.movie_detail

import com.example.movieskmm.domain.model.Movie
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse

data class MovieDetailsState (
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val movie: MovieDetailResponse? = null
) {
    constructor() : this(
        isLoading = false,
        page = 1,
        query = "",
        movie = null
    )
}