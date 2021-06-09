package io.github.thang86.movieapp.domain.usecase

import io.github.thang86.movieapp.data.model.uimodel.CastViewItem
import io.github.thang86.movieapp.data.repository.RemoteRepository
import io.github.thang86.movieapp.domain.mapper.CastItemMapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieCreditUseCase @Inject constructor(
    private val repository: RemoteRepository,
    private val castItemMapper: CastItemMapper
) {
    fun getMovieCredits(movieId: Int): Observable<List<CastViewItem>> {
        return repository.getMovieCredits(movieId).map {
            castItemMapper.mapFrom(it).orEmpty()
        }
    }
}

