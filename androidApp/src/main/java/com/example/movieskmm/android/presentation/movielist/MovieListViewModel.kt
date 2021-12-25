package com.example.movieskmm.android.presentation.movielist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieskmm.datasource.network.MovieService
import com.example.movieskmm.domain.model.Movie
import com.example.movieskmm.domain.model.MovieResponse
import com.example.movieskmm.interactors.movielist.GetMoviesUseCase
import com.example.movieskmm.presentation.movie_list.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    //private val movieService: MovieService
    private val useCase: GetMoviesUseCase
) : ViewModel() {


    val movies: MutableState<MovieResponse?> = mutableStateOf(null)
    val state: MutableState<MovieListState> = mutableStateOf(MovieListState())


    init {

        getMovies()


//        viewModelScope.launch {
//            movies.value = useCase.execute()
//
//            println("MovieListViewModel Response ${movies.value!!.results[0].title}")
//        }


//        savedStateHandle.get<MovieResponse>("movieId")?.let { movieId ->
//            this.movies.value = movieId
//
//
//        }


    }

    private fun getMovies() {
        useCase.execute()
            .collectCommon(viewModelScope) { dataState ->

                println("MovieListViewModel ${dataState.isLoading}")

                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let { movies ->
                    println("MovieListViewModel ${movies}")

                    // state.value = state.value.copy(movies = movies.results)
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