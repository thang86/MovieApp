package io.github.thang86.movieapp.domain.usecase

import io.github.thang86.movieapp.data.model.uimodel.MovieDetailViewItem
import io.github.thang86.movieapp.data.repository.RemoteRepository
import io.github.thang86.movieapp.domain.mapper.MovieDetailItemMapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailUseCase @Inject constructor(
    private val repository: RemoteRepository,
    private val itemMapper: MovieDetailItemMapper
) {
    fun getMovieDetail(movieId: Int): Observable<MovieDetailViewItem> {
        return repository.getMovieDetail(movieId = movieId).map { itemMapper.mapFrom(it) }
    }
}



