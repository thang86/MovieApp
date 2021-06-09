package io.github.thang86.movieapp.data.repository

import io.github.thang86.movieapp.data.model.response.CastResponse
import io.github.thang86.movieapp.data.model.response.MovieDetailReponse
import io.github.thang86.movieapp.data.model.response.MovieResponse
import io.github.thang86.movieapp.data.service.RemoteApiService
import io.github.thang86.movieapp.domain.repository.IMovieRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(private val api: RemoteApiService) : IMovieRepository {
    override fun getPopularMovies(page: Int): Observable<MovieResponse> = api.getPopularMovies(page)
    override fun getUpComingMovies(page: Int): Observable<MovieResponse> = api.getUpComingMovies(page)
    override fun getNowPlayingMovies(page: Int): Observable<MovieResponse> = api.getNowPlayingMovies(page)
    override fun getSimilarMovies(movieId: Int): Observable<MovieResponse> = api.getSimilarMovies(movieId)
    override fun getRecommendationMovies(movieId: Int): Observable<MovieResponse> = api.getRecommendationMovies(movieId)
    override fun getMovieCredits(movieId: Int): Observable<CastResponse> = api.getMovieCredits(movieId)
    override fun getMovieDetail(movieId: Int): Observable<MovieDetailReponse> = api.getMovieDetail(movieId)
    override fun searchMovie(query: String, page: Int): Observable<MovieResponse> = api.searchMovie(query, page)
}