package com.wildan.wemovies.core.data

import com.wildan.wemovies.core.data.source.local.LocalDataSource
import com.wildan.wemovies.core.data.source.remote.RemoteDataSource
import com.wildan.wemovies.core.data.source.remote.network.ApiResponse
import com.wildan.wemovies.core.data.source.remote.response.MoviesResponse
import com.wildan.wemovies.core.domain.model.Movies
import com.wildan.wemovies.core.domain.repository.IMoviesRepository
import com.wildan.wemovies.core.utils.AppExecutors
import com.wildan.wemovies.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MoviesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMoviesRepository {

    override fun getAllMovies(): Flow<Resource<List<Movies>>> =
        object: com.wildan.wemovies.core.data.NetworkBoundResource<List<Movies>, List<MoviesResponse>>() {
            override fun loadFromDB(): Flow<List<Movies>> {
                return localDataSource.getAllMovies().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movies>?): Boolean =
                data == null || data.isEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MoviesResponse>) {
                val moviesList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(moviesList)
            }
        }.asFlow()

    override fun getBookmarkMovies(): Flow<List<Movies>> {
        return localDataSource.getBookmarkMovies().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setBookmarkMovies(movies: Movies, state: Boolean) {
        val moviesEntity = DataMapper.mapDomainToEntity(movies)
        appExecutors.diskIO().execute { localDataSource.setBookmarkMovies(moviesEntity, state) }
    }

}