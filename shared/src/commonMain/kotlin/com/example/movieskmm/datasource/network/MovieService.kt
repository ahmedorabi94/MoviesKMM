package com.example.movieskmm.datasource.network

import com.example.movieskmm.domain.model.MovieResponse

interface MovieService {

    suspend fun getNowPlayingMoviesAsync(): MovieResponse

//    suspend fun getTopRated(apiKey: String): MovieResponse
//
//    suspend fun getComingSoon(apiKey: String): MovieResponse
//
//    suspend fun getPopularMovies(apiKey: String): MovieResponse
}