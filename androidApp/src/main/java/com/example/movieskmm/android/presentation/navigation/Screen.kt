package com.example.movieskmm.android.presentation.navigation

sealed class Screen(val route : String) {

    object MovieList : Screen("movieList")
    object MovieDetail : Screen("movieDetail")

}