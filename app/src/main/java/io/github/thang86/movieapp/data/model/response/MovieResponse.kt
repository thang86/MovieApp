package io.github.thang86.movieapp.data.model.response

import io.github.thang86.movieapp.data.model.Movie
import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("page") val page: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("results") val results: ArrayList<Movie>?
)