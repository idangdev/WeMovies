package com.wildan.wemovies.core.domain.repository

import com.wildan.wemovies.core.data.Resource
import com.wildan.wemovies.core.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {

    fun getAllMovies(): Flow<Resource<List<Movies>>>

    fun getBookmarkMovies(): Flow<List<Movies>>

    fun setBookmarkMovies(movies: Movies, state: Boolean)

}