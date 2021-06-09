package io.github.thang86.movieapp.domain.decider

import io.github.thang86.movieapp.util.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastItemDecider @Inject constructor() {
    fun provideImagePath(path: String?): String? = "${Constants.PROFILE_PATH}$path"
}