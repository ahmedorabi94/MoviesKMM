package com.example.movieskmm.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument

import androidx.navigation.compose.rememberNavController
import com.example.movieskmm.android.presentation.moviedetail.MovieDetail
import com.example.movieskmm.android.presentation.moviedetail.MovieDetailViewModel
import com.example.movieskmm.android.presentation.movielist.MovieList
import com.example.movieskmm.android.presentation.movielist.MovieListViewModel

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MovieList.route) {
        composable(route = Screen.MovieList.route) { navBackStack ->

            val factory = HiltViewModelFactory(LocalContext.current, navBackStack)
            val viewModel: MovieListViewModel = viewModel("MovieListViewModel", factory)


            MovieList(state = viewModel.state.value, onMovieItemClick = { movieId ->
                navController.navigate(Screen.MovieDetail.route + "/$movieId")
            })

        }

        composable(route = Screen.MovieDetail.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") {
                type = NavType.StringType
            }
            )

        ) { navBackStack ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStack)
            val viewModel: MovieDetailViewModel = viewModel("MovieDetailViewModel", factory)


            MovieDetail(movieId = viewModel.movieId.value)


        }
    }

}