package com.example.movieskmm.android.presentation.moviedetail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieskmm.android.presentation.components.MovieImage
import com.example.movieskmm.android.presentation.movielist.MovieListViewModel
import com.example.movieskmm.android.presentation.theme.AppTheme
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieDetail(MovieDetail : MovieDetailResponse?){


    AppTheme(displayProgressBar = false) {
        if (MovieDetail == null){
            Text(text = "Error")
        }else {
            Text(text = "Movie Title :  ${MovieDetail.title}")
            MovieImage(url = MovieDetail.backdrop_path, desc = MovieDetail.title)
            //MovieImage(url = "http://image.tmdb.org/t/p/w500/jlGmlFOcfo8n5tURmhC7YVd4Iyy.jpg", desc = "")


        }
    }



}