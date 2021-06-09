package io.github.thang86.movieapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.thang86.movieapp.presentation.detail.MovieDetailViewModel
import io.github.thang86.movieapp.presentation.home.HomeViewModel
import io.github.thang86.movieapp.presentation.list.MovieListViewModel
import io.github.thang86.movieapp.presentation.movies.MoviesViewModel
import io.github.thang86.movieapp.presentation.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindsMoviesViewModel(viewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindsSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindsMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindsMovieListViewModel(viewModel: MovieListViewModel): ViewModel

}