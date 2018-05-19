package com.example.sfcar.mostpopularmovies.data.repository.datasource

import com.example.sfcar.mostpopularmovies.data.model.MovieListResponseDto
import com.example.sfcar.mostpopularmovies.data.net.MoviesApiService
import io.reactivex.Observable
import javax.inject.Inject

class MoviesDataStoreImpl @Inject constructor(private val moviesApiService: MoviesApiService) : MoviesDataStore {

    override fun getPopularMovies(page: Int): Observable<MovieListResponseDto> = moviesApiService.getPopularMovies(page)

}