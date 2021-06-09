package io.github.thang86.movieapp.domain.repository

import io.github.thang86.movieapp.data.model.response.CastResponse
import io.github.thang86.movieapp.data.model.response.MovieDetailReponse
import io.github.thang86.movieapp.data.model.response.MovieResponse
import io.reactivex.Observable

interface IMovieRepository {
    fun getPopularMovies(page: Int): Observable<MovieResponse>
    fun getUpComingMovies(page: Int): Observable<MovieResponse>
    fun getNowPlayingMovies(page: Int): Observable<MovieResponse>
    fun getSimilarMovies(movieId: Int): Observable<MovieResponse>
    fun getRecommendationMovies(movieId: Int): Observable<MovieResponse>
    fun getMovieCredits(movieId: Int): Observable<CastResponse>
    fun getMovieDetail(movieId: Int): Observable<MovieDetailReponse>
    fun searchMovie(query: String, page: Int): Observable<MovieResponse>
}