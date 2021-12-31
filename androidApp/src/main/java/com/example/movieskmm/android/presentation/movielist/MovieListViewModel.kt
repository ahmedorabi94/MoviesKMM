package com.example.movieskmm.android.presentation.movielist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieskmm.domain.model.Movie
import com.example.movieskmm.interactors.movielist.GetMoviesUseCase
import com.example.movieskmm.interactors.movielist.SearchMoviesUseCase
import com.example.movieskmm.presentation.movie_list.MovieListEvents
import com.example.movieskmm.presentation.movie_list.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val useCase: GetMoviesUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase,
) : ViewModel() {

    val state: MutableState<MovieListState> = mutableStateOf(MovieListState())


    init {
        onTriggerEvent(MovieListEvents.LoadMovies)
    }

     fun onTriggerEvent(event: MovieListEvents) {

        when (event) {
            MovieListEvents.LoadMovies -> {
                getMovies()
            }
            MovieListEvents.NextPage -> {
                nextPage()
            }
           is  MovieListEvents.OnUpdateQuery -> {
               state.value = state.value.copy(query = event.query)
            }
            MovieListEvents.SearchMovie -> {
                newSearch()
            }
        }

    }

    private fun newSearch() {
        state.value = state.value.copy(page = 1 , movies = listOf())
        searchMovies()
    }

    private fun nextPage() {
        state.value = state.value.copy(page = state.value.page + 1)
        getMovies()
    }

    private fun getMovies() {
        useCase.execute(state.value.page)
            .collectCommon(viewModelScope) { dataState ->

                println("MovieListViewModel ${dataState.isLoading}")

                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let { movies ->
                    println("MovieListViewModel ${movies}")
                    appendMovies(movies.results)
                }

                dataState.message?.let {
                    println("MovieListViewModel ${it}")

                }


            }
    }

    private fun searchMovies() {
        searchMoviesUseCase.execute(query = state.value.query)
            .collectCommon(viewModelScope) { dataState ->

                println("MovieListViewModel ${dataState.isLoading}")

                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let { movies ->
                    println("MovieListViewModel ${movies}")
                    appendMovies(movies.results)
                }

                dataState.message?.let {
                    println("MovieListViewModel ${it}")

                }


            }
    }

    private fun appendMovies(movies: List<Movie>) {
        val curr = ArrayList(state.value.movies)
        curr.addAll(movies)
        state.value = state.value.copy(movies = curr)
    }

}