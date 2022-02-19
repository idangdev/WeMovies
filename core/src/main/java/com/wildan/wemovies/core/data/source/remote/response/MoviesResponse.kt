package com.wildan.wemovies.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("backdrop_path")
    val backdrop_path: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val release_date: String
)
