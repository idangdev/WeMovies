package com.wildan.wemovies.core.data.source.local

import com.wildan.wemovies.core.data.source.local.entity.MoviesEntity
import com.wildan.wemovies.core.data.source.local.room.MoviesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val moviesDao: MoviesDao){

    fun getAllMovies(): Flow<List<MoviesEntity>> = moviesDao.getAllMovies()

    fun getBookmarkMovies(): Flow<List<MoviesEntity>> = moviesDao.getBookmarkMovies()

    suspend fun insertMovies(moviesList: List<MoviesEntity>) = moviesDao.insertMovies(moviesList)

    fun setBookmarkMovies(movies: MoviesEntity, newState: Boolean) {
        movies.isBookmark = newState
        moviesDao.updateBookmarMovies(movies)
    }

}