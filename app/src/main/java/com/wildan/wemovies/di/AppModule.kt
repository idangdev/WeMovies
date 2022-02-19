package com.wildan.wemovies.di

import com.wildan.wemovies.core.domain.usecase.MoviesInteractor
import com.wildan.wemovies.core.domain.usecase.MoviesUseCase
import com.wildan.wemovies.detail.DetailMoviesViewModel
import com.wildan.wemovies.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MoviesUseCase> { MoviesInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMoviesViewModel(get()) }
}