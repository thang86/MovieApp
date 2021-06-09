package io.github.thang86.movieapp.di

import io.github.thang86.movieapp.presentation.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindHomeActivity(): HomeActivity
}