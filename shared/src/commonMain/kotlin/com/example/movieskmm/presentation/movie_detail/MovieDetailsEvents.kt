package com.example.movieskmm.presentation.movie_detail

sealed class MovieDetailsEvents{
   data class  GETMovieDetails(val movieId : Int): MovieDetailsEvents()
}
