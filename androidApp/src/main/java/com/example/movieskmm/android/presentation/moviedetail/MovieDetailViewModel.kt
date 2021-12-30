package com.example.movieskmm.android.presentation.moviedetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse
import com.example.movieskmm.interactors.moviedetail.GetMoviesDetailUseCase
import com.example.movieskmm.presentation.movie_detail.MovieDetailsState
import com.example.movieskmm.presentation.movie_list.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: GetMoviesDetailUseCase

) : ViewModel() {

    val movie: MutableState<MovieDetailResponse?> = mutableStateOf(null)
    val movieId: MutableState<Int?> = mutableStateOf(null)
    val state: MutableState<MovieDetailsState> = mutableStateOf(MovieDetailsState())

    init {


        savedStateHandle.get<Int>("movieId")?.let { movieId ->
            this.movieId.value = movieId
        }

        getMoviesDetail()

    }

    private fun getMoviesDetail() {
        useCase.execute(movieId = movieId.value!!)
            .collectCommon(viewModelScope) { dataState ->

                println("MovieDetailViewModel ${dataState.isLoading}")

                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let { movieDetail ->
                    println("MovieDetailViewModel ${movieDetail}")

                    this.movie.value = movieDetail
                    // state.value = state.value.copy(movie = movieDetail)
                    //  appendMovies(movies.results)
                }

                dataState.message?.let {
                    println("MovieDetailViewModel ${it}")

                }


            }
    }


}