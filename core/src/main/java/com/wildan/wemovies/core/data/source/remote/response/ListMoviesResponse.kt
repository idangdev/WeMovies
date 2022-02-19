package com.wildan.wemovies.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMoviesResponse(

    @field: SerializedName("results")
    val results: List<MoviesResponse>

)
