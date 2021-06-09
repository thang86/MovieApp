package io.github.thang86.movieapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.thang86.movieapp.base.viewmodel.BaseViewModel
import io.github.thang86.movieapp.data.enum.MovieType
import io.github.thang86.movieapp.domain.usecase.MovieListUseCase
import io.github.thang86.movieapp.presentation.movies.MoviesFragmentViewState
import io.github.thang86.movieapp.presentation.movies.MoviesItemCombiner
import io.reactivex.rxkotlin.Observables
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase
) : BaseViewModel() {
    /** LiveData for ViewState **/
    private val liveDataViewState = MutableLiveData<MoviesFragmentViewState>()
    val liveDataViewState_: LiveData<MoviesFragmentViewState> = liveDataViewState

    fun getMovies() {
        return Observables.zip(
            movieListUseCase.getMovies(MovieType.POPULAR),
            movieListUseCase.getMovies(MovieType.NOW_PLAYING),
            movieListUseCase.getMovies(MovieType.UPCOMING),
            MoviesItemCombiner()
        ).sendRequest {
            liveDataViewState.value = it
        }

    }
}