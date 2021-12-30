package com.example.movieskmm.interactors.movielist

import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.domain.model.MovieResponse
import com.example.movieskmm.domain.util.CommonFlow
import com.example.movieskmm.domain.util.DataState
import com.example.movieskmm.domain.util.asCommonFlow
import kotlinx.coroutines.flow.flow

class SearchMoviesUseCase (private val movieService: MovieService){


    fun execute(query : String) : CommonFlow<DataState<MovieResponse>> {

        return flow {

            emit(DataState.loading())
            try {
                val response = movieService.searchMoviesApi(query)
                emit(DataState.data(null,response))

            }catch (e : Exception){
                emit(DataState.error(message = e.message ?: " "))
            }

        }.asCommonFlow()

    }


}