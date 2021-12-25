package com.example.movieskmm.di

import com.example.movieskmm.datasource.network.KtorClientFactory
import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.datasource.network.MovieServiceImp

class NetworkModule {

    val movieService : MovieService by lazy {
        MovieServiceImp(httpclient = KtorClientFactory().build())
    }
}