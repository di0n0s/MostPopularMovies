package com.example.sfcar.mostpopularmovies.model.mapper

import android.content.Context
import com.example.sfcar.mostpopularmovies.UnitTest
import com.example.sfcar.mostpopularmovies.domain.model.Movie
import com.example.sfcar.mostpopularmovies.domain.model.MovieListPagination
import com.example.sfcar.mostpopularmovies.model.BaseMovieViewModel
import com.example.sfcar.mostpopularmovies.model.MovieListPaginationViewModel
import com.example.sfcar.mostpopularmovies.model.MovieViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

/*            _MMMMM`
 *     __MMMMMMMMM`       J        openTrends Solucions i Sistemes, S.L.
 * JMMMMMMMMMMMMF       JM         http://www.opentrends.net
 * MMMMMMMMMMF       _JMM`         info@opentrends.net
 * MMMMMMMF`    .JMMMMF`
 * """")    _JMMMMMMF`             C/ Veneçuela, 105 4arta. Planta
 * _MMMMMMMMMMMMMMM`      .M)      08019 Barcelona
 * MMMMMMMMMMMMMF`     .JMM`       Spain
 * MMMMMMMMMM"     _MMMMMF
 * M4MMM""`   ._MMMMMMMM`          *************************************
 * _______MMMMMMMMMMMF             MostPopularMovies
 * MMMMMMMMMMMMMMMM"               *************************************
 * MMMMMMMMMMMMF"                  Copyright (C) 2018 openTrends, Tots els drets reservats
 * MMMMMMMM""                      Copyright (C) 2018 openTrends, All Rights Reserved
 *
 *                                 This program is free software; you can redistribute it and/or modify
 *                                 it under the terms of the GNU General Public License as published by
 *                                 the Free Software Foundation; either version 2 of the License, or
 *                                 (at your option) any later version.
 *
 *                                 This program is distributed in the hope that it will be useful,
 *                                 but WITHOUT ANY WARRANTY; without even the implied warranty of
 *                                 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *                                 GNU General Public License for more details.
 *
 *                                 You should have received a copy of the GNU General Public License along
 *                                 with this program; if not, write to the Free Software Foundation, Inc.,
 *                                 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
class MovieListPaginationViewModelMapperTest : UnitTest() {

    @Mock
    private lateinit var context: Context

    private val list: List<Movie> = listOf(
            Movie("Spiderman", "2018/02/04", "Spiderman Movie", "/pic.jpg"),
            Movie("Venom", "", "", "")
    )

    companion object {
        private const val CURRENT_PAGE = 425
        private const val PAGES_NUMBER = 560
    }

    @Test
    fun turnInto() {
        doReturn("Unknown")
                .`when`(context)
                .getString(any())
        val movieListPaginationViewModel = MovieListPaginationViewModelMapper.turnInto(MovieListPagination(PAGES_NUMBER, CURRENT_PAGE , list), context)
        assertThat(movieListPaginationViewModel, `is`<Any>(instanceOf<Any>(MovieListPaginationViewModel::class.java)))
        assertThat(movieListPaginationViewModel.currentPage, `is`<Int>(CURRENT_PAGE))
        assertThat(movieListPaginationViewModel.pagesNumber, `is`<Int>(PAGES_NUMBER))
        assertThat(movieListPaginationViewModel.movieList.size, `is`(2))
    }

}