package com.example.movieskmm.interactors.moviedetail

import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse
import com.example.movieskmm.domain.util.CommonFlow
import com.example.movieskmm.domain.util.DataState
import com.example.movieskmm.domain.util.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetMoviesDetailUseCase (private val movieService: MovieService){


    fun execute(movieId : Int) : CommonFlow<DataState<MovieDetailResponse>> {

        return flow {

            emit(DataState.loading())
            try {
                val response = movieService.getMovieDetailsAsync(movieId)
                emit(DataState.data(null,response))

            }catch (e : Exception){
                emit(DataState.error(message = e.message ?: " "))
            }

        }.asCommonFlow()

    }


}