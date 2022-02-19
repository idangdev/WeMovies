package com.wildan.wemovies.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wildan.wemovies.core.domain.usecase.MoviesUseCase

class HomeViewModel(moviesUseCase: MoviesUseCase): ViewModel() {

    val movies = moviesUseCase.getAllMovies().asLiveData()

}