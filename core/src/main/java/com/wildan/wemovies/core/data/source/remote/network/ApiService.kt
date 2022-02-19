package com.wildan.wemovies.core.data.source.remote.network

import com.wildan.wemovies.core.BuildConfig
import com.wildan.wemovies.core.data.source.remote.response.ListMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = BuildConfig.TMDB_API_KEY
    }

    @GET("now_playing")
    suspend fun getList(
        @Query("api_key")  api_key: String
    ): ListMoviesResponse
}