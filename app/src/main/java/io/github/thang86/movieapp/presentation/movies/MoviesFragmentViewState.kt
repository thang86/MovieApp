package io.github.thang86.movieapp.presentation.movies


import io.github.thang86.movieapp.data.model.uimodel.MovieListViewItem

class MoviesFragmentViewState(
    private val popularMovies: MovieListViewItem,
    private val nowPlayingMovies: MovieListViewItem,
    private val upComingMovies: MovieListViewItem
) {
    fun getPopularMovies(): MovieListViewItem = popularMovies

    fun getNowPlayingMovies(): MovieListViewItem = nowPlayingMovies

    fun getUpComingMovies(): MovieListViewItem = upComingMovies

    fun getPopularMoviesViewPagerTitle() = "Popular"

    fun getUpComingMoviesViewPagerTitle() = "Upcoming"


}

