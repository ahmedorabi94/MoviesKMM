package com.example.movieskmm.presentation.movie_list

sealed class MovieListEvents {

    object LoadMovies : MovieListEvents()
    object NextPage : MovieListEvents()
    object SearchMovie : MovieListEvents()
    data class OnUpdateQuery(val query: String) : MovieListEvents()
}