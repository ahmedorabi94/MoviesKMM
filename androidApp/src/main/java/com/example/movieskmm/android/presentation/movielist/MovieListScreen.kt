package com.example.movieskmm.android.presentation.movielist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.movieskmm.android.presentation.movielist.component.MovieCard
import com.example.movieskmm.android.presentation.movielist.component.SearchAppBar
import com.example.movieskmm.android.presentation.theme.AppTheme
import com.example.movieskmm.presentation.movie_list.MovieListEvents
import com.example.movieskmm.presentation.movie_list.MovieListState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieList(
    state: MovieListState,
    onTriggerNextPage: (MovieListEvents) -> Unit,
    onMovieItemClick: (Int) -> Unit
) {

    AppTheme(displayProgressBar = state.isLoading) {

        if (state.isLoading && state.movies.isEmpty()) {

        } else if (state.movies.isEmpty()) {

        } else {

            Scaffold(
                topBar = {
                    SearchAppBar(query = state.query, onQueryChange = {
                        onTriggerNextPage(MovieListEvents.OnUpdateQuery(it))
                    }, onExecuteSearch = {
                        onTriggerNextPage(MovieListEvents.SearchMovie)
                    })
                }
            ) {
                LazyColumn {
                    itemsIndexed(items = state.movies) { index, movie ->
                        if ((index + 1) >= (state.page * 20) && !state.isLoading) {
                            onTriggerNextPage(MovieListEvents.NextPage)
                        }
                        MovieCard(movie = movie, onClick = {
                            onMovieItemClick(movie.id)
                        }
                        )
                    }


                }
            }


        }


    }


}