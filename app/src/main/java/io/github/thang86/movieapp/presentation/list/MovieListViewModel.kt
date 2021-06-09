package io.github.thang86.movieapp.presentation.list

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.thang86.movieapp.base.viewmodel.BaseViewModel
import io.github.thang86.movieapp.data.enum.MovieListPageType
import io.github.thang86.movieapp.data.enum.MovieType
import io.github.thang86.movieapp.data.model.uimodel.MovieListViewItem
import io.github.thang86.movieapp.data.model.uimodel.MovieViewItem
import io.github.thang86.movieapp.domain.usecase.MovieListUseCase
import io.github.thang86.movieapp.domain.usecase.SearchMovieUseCase
import io.github.thang86.movieapp.presentation.list.adapter.MovieItemDataSource
import io.reactivex.Observable
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
    private val searchMovieUseCase: SearchMovieUseCase
) : BaseViewModel() {
    /** LiveData for ViewState **/
    private val liveDataViewState = MutableLiveData<MovieListFragmentViewState>()
    val liveDataViewState_: LiveData<MovieListFragmentViewState> = liveDataViewState
    private var dataSource: MovieItemDataSource? = null

    init {
        updateUIState(showLoading = true)
    }

    override fun handleIntent(extras: Bundle) {
        val args = MovieListFragmentArgs.fromBundle(extras)
        this.liveDataViewState.value = MovieListFragmentViewState(pageType = args.pageType, searchQuery = args.searchQuery)
    }

    fun getMovieList(): LiveData<PagedList<MovieViewItem>> {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(true)
            .build()
        return initPagedListBuilder(config).build()
    }

    private fun initPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, MovieViewItem> {
        val dataSourceFactory = object : DataSource.Factory<Int, MovieViewItem>() {
            override fun create(): DataSource<Int, MovieViewItem> {
                dataSource = MovieItemDataSource(
                    this@MovieListViewModel,
                    liveDataViewState.value?.getPageType(),
                    liveDataViewState.value?.getSearchQuery()
                )
                return dataSource!!
            }
        }
        return LivePagedListBuilder<Int, MovieViewItem>(dataSourceFactory, config)
    }

    fun getMovies(pageType: MovieListPageType, searchQuery: String? = null, page: Int): Observable<MovieListViewItem> {
        return when (pageType) {
            MovieListPageType.POPULAR -> movieListUseCase.getMovies(movieType = MovieType.POPULAR, page = page)
            MovieListPageType.UPCOMING -> movieListUseCase.getMovies(movieType = MovieType.UPCOMING, page = page)
            MovieListPageType.SEARCH -> searchMovieUseCase.searchMovie(searchQuery.orEmpty(), page)
        }
    }

}