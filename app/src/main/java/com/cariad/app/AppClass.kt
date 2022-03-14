package com.cariad.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

import com.cariad.app.di.*


class AppClass: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppClass)
            modules(listOf(AppModule, RepositoryModule, ViewModelModule))
        }
    }

}