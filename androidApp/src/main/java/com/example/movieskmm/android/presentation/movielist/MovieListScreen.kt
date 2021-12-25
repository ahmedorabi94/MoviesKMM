package com.example.movieskmm.android.presentation.movielist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.example.movieskmm.android.presentation.movielist.component.MovieCard
import com.example.movieskmm.android.presentation.theme.AppTheme
import com.example.movieskmm.presentation.movie_list.MovieListState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieList(
    state: MovieListState,
    onMovieItemClick: (String) -> Unit
) {

    AppTheme(displayProgressBar = state.isLoading) {

        if (state.isLoading && state.movies.isEmpty()){

        }else if (state.movies.isEmpty()){

        }else{

            LazyColumn {
                itemsIndexed(items = state.movies) { index, movie ->
                    MovieCard(movie = movie, onClick = {
                        onMovieItemClick(movie.title)
                    }
                    )
                }


            }
        }




    }


}