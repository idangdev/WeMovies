package com.wildan.wemovies.core.data.source.local.room

import androidx.room.*
import com.wildan.wemovies.core.data.source.local.entity.MoviesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MoviesEntity>>

    @Query("SELECT * FROM movies where isBookmark = 1")
    fun getBookmarkMovies(): Flow<List<MoviesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MoviesEntity>)

    @Update
    fun updateBookmarMovies(movies: MoviesEntity)

}