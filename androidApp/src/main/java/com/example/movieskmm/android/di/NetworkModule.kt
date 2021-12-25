package com.example.movieskmm.android.di

import com.example.movieskmm.datasource.network.KtorClientFactory
import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.datasource.network.MovieServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideMovieService(
        httpClient: HttpClient,
    ): MovieService {
        return MovieServiceImp(
            httpclient = httpClient,
        )
    }
}
