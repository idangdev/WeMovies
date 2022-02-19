package com.wildan.wemovies.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wildan.wemovies.core.domain.usecase.MoviesUseCase

class BookmarkViewModel(moviesUseCase: MoviesUseCase): ViewModel() {
    val bookmarkMovies = moviesUseCase.getBookmarkMovies().asLiveData()
}