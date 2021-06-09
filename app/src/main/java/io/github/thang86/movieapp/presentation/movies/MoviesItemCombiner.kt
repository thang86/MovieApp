package io.github.thang86.movieapp.presentation.movies

import io.github.thang86.movieapp.data.model.uimodel.MovieListViewItem
import io.github.thang86.movieapp.presentation.movies.MoviesFragmentViewState

class MoviesItemCombiner : (MovieListViewItem, MovieListViewItem, MovieListViewItem) -> MoviesFragmentViewState {
    override fun invoke(p1: MovieListViewItem, p2: MovieListViewItem, p3: MovieListViewItem): MoviesFragmentViewState {
        return MoviesFragmentViewState(popularMovies = p1, nowPlayingMovies = p2, upComingMovies = p3)
    }
}