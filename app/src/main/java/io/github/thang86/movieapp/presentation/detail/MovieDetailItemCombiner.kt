package io.github.thang86.movieapp.presentation.detail

import io.github.thang86.movieapp.data.model.uimodel.CastViewItem
import io.github.thang86.movieapp.data.model.uimodel.MovieDetailViewItem
import io.github.thang86.movieapp.data.model.uimodel.MovieListViewItem
import io.github.thang86.movieapp.presentation.detail.MovieDetailFragmentViewState

class MovieDetailItemCombiner : (MovieDetailViewItem, MovieListViewItem, List<CastViewItem>, MovieListViewItem) -> MovieDetailFragmentViewState {
    override fun invoke(p1: MovieDetailViewItem, p2: MovieListViewItem, p3: List<CastViewItem>, p4: MovieListViewItem): MovieDetailFragmentViewState {
        return MovieDetailFragmentViewState(movieDetailViewItem = p1, similarMovies = p2, casts = p3, recommendationMovies = p4)
    }
}