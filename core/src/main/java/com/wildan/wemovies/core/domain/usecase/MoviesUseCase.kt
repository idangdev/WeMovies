package com.wildan.wemovies.core.domain.usecase

import com.wildan.wemovies.core.data.Resource
import com.wildan.wemovies.core.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesUseCase {
    fun getAllMovies(): Flow<Resource<List<Movies>>>
    fun getBookmarkMovies(): Flow<List<Movies>>
    fun setBookmarkMovies(movies: Movies, state: Boolean)
}