package io.github.thang86.movieapp.data.model.uimodel

data class MovieListViewItem(
    val page: Int,
    val totalPage: Int,
    val movies: List<MovieViewItem>
) {
}