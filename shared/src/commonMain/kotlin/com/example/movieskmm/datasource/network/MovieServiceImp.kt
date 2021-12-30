package com.example.movieskmm.datasource.network

import com.example.movieskmm.domain.model.MovieResponse
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse
import io.ktor.client.*
import io.ktor.client.request.*

class MovieServiceImp(private val httpclient : HttpClient) : MovieService {


    override suspend fun getNowPlayingMoviesAsync(page : Int): MovieResponse {

        val strValue = httpclient.get<MovieResponse>{
            url("$BASE_URL/movie/now_playing?api_key=$apiKey&page=$page")
        }

        return strValue

    }

    override suspend fun searchMoviesApi(query: String): MovieResponse {

        val strValue = httpclient.get<MovieResponse>{
            url("$BASE_URL/search/multi?api_key=$apiKey&query=$query")

        }

        return strValue
    }

    override suspend fun getMovieDetailsAsync(movieId : Int): MovieDetailResponse {

        val strValue = httpclient.get<MovieDetailResponse>{
            url("$BASE_URL/movie/$movieId?api_key=$apiKey")
        }

        return strValue
    }

    companion object {
        const val apiKey: String = "97c261053713fdbd691f42aa664c1463"
        const val BASE_URL = "https://api.themoviedb.org/3"

    }
}