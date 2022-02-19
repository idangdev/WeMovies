package com.wildan.wemovies.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MoviesEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "backdrop_path")
    var backdrop_path: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "release_date")
    var release_date: String,

    @ColumnInfo(name = "isBookmark")
    var isBookmark: Boolean = false
)