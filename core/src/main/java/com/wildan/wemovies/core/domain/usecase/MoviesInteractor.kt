package com.wildan.wemovies.core.domain.usecase

import com.wildan.wemovies.core.domain.model.Movies
import com.wildan.wemovies.core.domain.repository.IMoviesRepository

class MoviesInteractor (private val moviesRepository: IMoviesRepository): MoviesUseCase {
    override fun getAllMovies() = moviesRepository.getAllMovies()

    override fun getBookmarkMovies() = moviesRepository.getBookmarkMovies()

    override fun setBookmarkMovies(movies: Movies, state: Boolean) = moviesRepository.setBookmarkMovies(movies, state)

}