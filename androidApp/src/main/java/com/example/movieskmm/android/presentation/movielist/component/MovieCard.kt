package com.example.movieskmm.android.presentation.movielist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieskmm.android.presentation.components.MovieImage
import com.example.movieskmm.domain.model.Movie


@Composable
fun MovieCard(movie: Movie, onClick: () -> Unit) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp, top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {

        Column() {

            MovieImage(url = movie.backdrop_path, desc = movie.title ?: "")

            Row(modifier = Modifier.fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp , start = 8.dp, end = 8.dp))
            {
                Text(
                    text = movie.title ?: "",
                    modifier = Modifier
                     .fillMaxWidth(0.65f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h3
                )

                Text(
                    text = "Vote Average : " + movie.vote_average.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h5
                )


            }



        }


    }

}