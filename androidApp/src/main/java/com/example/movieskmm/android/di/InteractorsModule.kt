package com.example.movieskmm.android.di

import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.interactors.movielist.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideMoviesUseCase(
        movieService: MovieService,
    ): GetMoviesUseCase {
        return GetMoviesUseCase(
           movieService = movieService
        )
    }

}
