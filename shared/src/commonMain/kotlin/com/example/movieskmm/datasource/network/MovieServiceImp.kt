package com.example.movieskmm.datasource.network

import com.example.movieskmm.domain.model.MovieResponse
import io.ktor.client.*
import io.ktor.client.request.*

class MovieServiceImp(private val httpclient : HttpClient) : MovieService {


    override suspend fun getNowPlayingMoviesAsync(): MovieResponse {

        val strValue = httpclient.get<MovieResponse>{
            url("$BASE_URL/movie/now_playing?api_key=$apiKey")
        }

        return strValue

    }

    companion object {
        const val apiKey: String = "97c261053713fdbd691f42aa664c1463"
        const val BASE_URL = "https://api.themoviedb.org/3"

    }
}