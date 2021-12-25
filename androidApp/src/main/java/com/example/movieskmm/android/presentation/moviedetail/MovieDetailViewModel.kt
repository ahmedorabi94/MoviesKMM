package com.example.movieskmm.android.presentation.moviedetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {

    val movieId: MutableState<String?> = mutableStateOf(null)


    init {


        savedStateHandle.get<String>("movieId")?.let { movieId ->
            this.movieId.value = movieId


        }


    }


}