package com.wildan.wemovies

import android.app.Application
import com.wildan.wemovies.core.di.databaseModule
import com.wildan.wemovies.core.di.networkModule
import com.wildan.wemovies.core.di.repositoryModule
import com.wildan.wemovies.di.useCaseModule
import com.wildan.wemovies.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}