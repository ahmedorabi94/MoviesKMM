package com.example.movieskmm.android.presentation.moviedetail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.movieskmm.android.presentation.components.MovieImage
import com.example.movieskmm.android.presentation.theme.AppTheme


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieDetail(movieId : String?){

    AppTheme(displayProgressBar = false) {
        if (movieId == null){
            Text(text = "Error")
        }else {
            Text(text = "Movie Title :  ${movieId}")

            //MovieImage(url = "http://image.tmdb.org/t/p/w500/jlGmlFOcfo8n5tURmhC7YVd4Iyy.jpg", desc = "")


        }
    }



}