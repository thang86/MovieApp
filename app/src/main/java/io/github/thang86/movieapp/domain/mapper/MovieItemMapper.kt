package io.github.thang86.movieapp.domain.mapper

import io.github.thang86.movieapp.base.extension.orZero
import io.github.thang86.movieapp.data.model.response.MovieResponse
import io.github.thang86.movieapp.data.model.uimodel.MovieListViewItem
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem
import io.github.thang86.movieapp.domain.decider.MovieItemDecider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieItemMapper @Inject constructor(private val itemDecider: MovieItemDecider) :
    Mapper<MovieResponse, MovieListViewItem?> {
    override fun mapFrom(item: MovieResponse): MovieListViewItem? {
        return MovieListViewItem(
            page = item.page.orZero(),
            totalPage = item.totalPages.orZero(),
            movies = item.results?.map { movie ->
                MovieViewItem(
                    id = movie.id.orZero(),
                    imagePath = itemDecider.provideImagePath(movie.posterPath).orEmpty(),
                    title = movie.title.orEmpty()
                )
            }.orEmpty()
        )
    }
}