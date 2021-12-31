package com.example.movieskmm.di

import com.example.movieskmm.interactors.moviedetail.GetMoviesDetailUseCase

class GetMovieDetailsModule (val networkModule: NetworkModule) {

    val getMoviesDetailUseCase : GetMoviesDetailUseCase by lazy {
        GetMoviesDetailUseCase(networkModule.movieService)
    }
}