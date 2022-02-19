package com.wildan.wemovies.detail

import androidx.lifecycle.ViewModel
import com.wildan.wemovies.core.domain.model.Movies
import com.wildan.wemovies.core.domain.usecase.MoviesUseCase

class DetailMoviesViewModel(private val moviesUseCase: MoviesUseCase): ViewModel() {

    fun setBookmarkMovies(movies: Movies, newStatus: Boolean) =
        moviesUseCase.setBookmarkMovies(movies, newStatus)

}