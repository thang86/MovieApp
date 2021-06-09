package io.github.thang86.movieapp.di

import io.github.thang86.movieapp.presentation.detail.MovieDetailFragment
import io.github.thang86.movieapp.presentation.list.MovieListFragment
import io.github.thang86.movieapp.presentation.movies.MoviesFragment
import io.github.thang86.movieapp.presentation.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment
}
