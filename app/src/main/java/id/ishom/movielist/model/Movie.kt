package id.ishom.movielist.model

import java.io.Serializable

data class Movie(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String
) : Serializable