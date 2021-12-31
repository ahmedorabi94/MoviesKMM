package com.example.movieskmm.android.presentation.moviedetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieskmm.interactors.moviedetail.GetMoviesDetailUseCase
import com.example.movieskmm.presentation.movie_detail.MovieDetailsEvents
import com.example.movieskmm.presentation.movie_detail.MovieDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCase: GetMoviesDetailUseCase

) : ViewModel() {

    val movieId: MutableState<Int?> = mutableStateOf(null)
    val state: MutableState<MovieDetailsState> = mutableStateOf(MovieDetailsState())

    init {


        savedStateHandle.get<Int>("movieId")?.let { movieId ->
            this.movieId.value = movieId
        }

        onTriggerEvents(MovieDetailsEvents.GETMovieDetails(movieId = movieId.value!!))

    }

    fun onTriggerEvents(events: MovieDetailsEvents) {
        when (events) {
            is MovieDetailsEvents.GETMovieDetails -> {
                getMoviesDetail(events.movieId)
            }
        }

    }

    private fun getMoviesDetail(movieId : Int) {
        useCase.execute(movieId = movieId)
            .collectCommon(viewModelScope) { dataState ->

                println("MovieDetailViewModel ${dataState.isLoading}")

                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let { movieDetail ->
                    println("MovieDetailViewModel ${movieDetail}")
                    state.value = state.value.copy(movie = movieDetail)
                }
                dataState.message?.let {
                    println("MovieDetailViewModel ${it}")

                }
            }
    }

}