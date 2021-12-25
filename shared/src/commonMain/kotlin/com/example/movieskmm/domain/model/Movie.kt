package com.example.movieskmm.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(

   // val movie_id: Int,
  //  val tv_id: Int,
  //  val first_air_date : String,
   // val name : String,
   // val original_name: String,
   // val origin_country : List<String>,

   // val media_type : String,
   // val author : String,
   // val content : String,
   // val url : String,

    val adult: Boolean,
    val backdrop_path: String,

   // val genre_ids: List<Long>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Long,
   // val category: String

)