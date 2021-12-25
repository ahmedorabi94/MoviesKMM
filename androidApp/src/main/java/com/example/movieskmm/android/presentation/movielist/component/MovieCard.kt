package com.example.movieskmm.android.presentation.movielist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

            MovieImage(url = movie.backdrop_path, desc = movie.title)

            Text(
                text = movie.title,
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.h3
            )


        }


    }

}