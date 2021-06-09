package io.github.thang86.movieapp.domain.mapper

import io.github.thang86.movieapp.base.extension.orZero
import io.github.thang86.movieapp.base.extension.simpleDateConvert
import io.github.thang86.movieapp.data.model.response.MovieDetailReponse
import io.github.thang86.movieapp.data.model.uimodel.MovieDetailViewItem
import io.github.thang86.movieapp.domain.decider.MovieDetailItemDecider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailItemMapper @Inject constructor(private val itemDecider: MovieDetailItemDecider) :
    Mapper<MovieDetailReponse, MovieDetailViewItem> {
    override fun mapFrom(item: MovieDetailReponse): MovieDetailViewItem {
        return MovieDetailViewItem(
            id = item.id.orZero(),
            backdropPath = itemDecider.provideBackdropPath(item.backdropPath).orEmpty(),
            genres = item.genres.orEmpty(),
            title = item.title.orEmpty(),
            overview = item.overview.orEmpty(),
            popularity = item.popularity.orZero(),
            imagePath = itemDecider.provideImagePath(item.posterPath).orEmpty(),
            releaseDate = item.releaseDate.simpleDateConvert("dd MMM yyyy").orEmpty(),
            runtime = "${item.runtime} min",
            status = item.status.orEmpty(),
            voteAverage = item.voteAverage?.toFloat().orZero() / 2
        )
    }
}