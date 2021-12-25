package com.example.movieskmm.di

import com.example.movieskmm.interactors.movielist.GetMoviesUseCase

class GetMoviesModule(val networkModule: NetworkModule) {

    val getMoviesUseCase : GetMoviesUseCase by lazy {
        GetMoviesUseCase(networkModule.movieService)
    }
}