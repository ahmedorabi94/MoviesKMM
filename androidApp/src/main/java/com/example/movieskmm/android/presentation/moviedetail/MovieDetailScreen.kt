package com.example.movieskmm.android.presentation.moviedetail

import android.hardware.TriggerEvent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieskmm.android.presentation.components.MovieImage
import com.example.movieskmm.android.presentation.movielist.MovieListViewModel
import com.example.movieskmm.android.presentation.theme.AppTheme
import com.example.movieskmm.domain.model.get_movie.MovieDetailResponse
import com.example.movieskmm.presentation.movie_detail.MovieDetailsEvents
import com.example.movieskmm.presentation.movie_detail.MovieDetailsState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun MovieDetail(state: MovieDetailsState,
                onTriggerEvent: (MovieDetailsEvents) -> Unit,
            ){


    AppTheme(displayProgressBar = state.isLoading) {
        if (state.movie == null){
            Text(text = "Error")
        }else {

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                item {
                    MovieImage(url = state.movie!!.backdrop_path, desc = state.movie!!.title)
                    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                        Row(modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp , start = 8.dp, end = 8.dp))
                        {
                            Text(
                                text = "Movie Title : " + state.movie!!.title,
                                modifier = Modifier
                                    .fillMaxWidth(0.60f)
                                    .wrapContentWidth(Alignment.Start),
                                style = MaterialTheme.typography.h3
                            )

                            Text(
                                text = "Vote Average : " + state.movie!!.vote_average.toString(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.End)
                                    .align(Alignment.CenterVertically),
                                style = MaterialTheme.typography.h6
                            )


                        }

                        Text(
                            text = "OverView : " + state.movie!!.overview,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "Original Language : " + state.movie!!.original_language,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Release Date : " + state.movie!!.release_date,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Tag Line  : " + state.movie!!.tagline,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Budget  : " + state.movie!!.budget,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Genres  : " + state.movie!!.genres.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Revenue  : " + state.movie!!.revenue,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            style = MaterialTheme.typography.h4
                        )
                    }

                }
            }


        }
    }



}