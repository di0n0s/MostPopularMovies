package com.example.sfcar.mostpopularmovies.presenters.mostPopularMovies

import com.example.sfcar.mostpopularmovies.domain.model.MovieListPagination
import com.example.sfcar.mostpopularmovies.presenters.base.BaseListPresenter

interface MostPopularMoviesPresenter<T> : BaseListPresenter<T> {

    fun onMovieListReceived(movieList: MovieListPagination)
    fun onQueryChangeListener(query: String)
    var query: String
}