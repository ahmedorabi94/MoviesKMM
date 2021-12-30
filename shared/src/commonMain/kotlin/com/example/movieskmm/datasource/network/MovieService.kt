package com.example.movieskmm.datasource.network

import com.example.movieskmm.domain.model.MovieResponse
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse

interface MovieService {

    suspend fun getNowPlayingMoviesAsync(page: Int): MovieResponse
    suspend fun getMovieDetailsAsync(movieId: Int): MovieDetailResponse
    suspend fun searchMoviesApi(query: String): MovieResponse

//    suspend fun getTopRated(apiKey: String): MovieResponse
//
//    suspend fun getComingSoon(apiKey: String): MovieResponse
//
//    suspend fun getPopularMovies(apiKey: String): MovieResponse
}