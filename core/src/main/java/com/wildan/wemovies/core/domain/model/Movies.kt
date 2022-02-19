package com.wildan.wemovies.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    val id: String,
    val title: String,
    val backdrop_path: String,
    val overview: String,
    val release_date: String,
    val isBookmark: Boolean
): Parcelable
