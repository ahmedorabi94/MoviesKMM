package com.example.movieskmm.di

import com.example.movieskmm.interactors.movielist.SearchMoviesUseCase

class SearchMoviesModule (val networkModule: NetworkModule) {

    val searchMoviesUseCase : SearchMoviesUseCase by lazy {
        SearchMoviesUseCase(networkModule.movieService)
    }
}