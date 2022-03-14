package com.cariad.app.di

import com.cariad.app.datasource.RemoteDataSource
import com.cariad.app.repository.RemoteDataRepository
import com.cariad.app.utils.Constants
import org.koin.dsl.module

val RepositoryModule = module {
    single{
        RemoteDataRepository(get())
    }

    single{
        RemoteDataSource(get(), Constants.DATA_UPDATE_INTERVAL)
    }

}