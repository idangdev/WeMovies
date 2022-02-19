package com.wildan.wemovies.core.utils

import com.wildan.wemovies.core.data.source.local.entity.MoviesEntity
import com.wildan.wemovies.core.data.source.remote.response.MoviesResponse
import com.wildan.wemovies.core.domain.model.Movies

object DataMapper {
    fun mapResponsesToEntities(input: List<MoviesResponse>): List<MoviesEntity> {
        val moviesList = ArrayList<MoviesEntity>()
        input.map {
            val movies = MoviesEntity(
                id = it.id,
                title = it.title,
                backdrop_path = it.backdrop_path,
                overview = it.overview,
                release_date = it.release_date,
                isBookmark = false
            )
            moviesList.add(movies)
        }
        return moviesList
    }

    fun mapEntitiesToDomain(input: List<MoviesEntity>): List<Movies> =
        input.map {
            Movies(
                id = it.id,
                title = it.title,
                backdrop_path = it.backdrop_path,
                overview = it.overview,
                release_date = it.release_date,
                isBookmark = it.isBookmark
            )
        }

    fun mapDomainToEntity(input: Movies) = MoviesEntity(
        id = input.id,
        title = input.title,
        backdrop_path = input.backdrop_path,
        overview = input.overview,
        release_date = input.release_date,
        isBookmark = input.isBookmark
    )

}