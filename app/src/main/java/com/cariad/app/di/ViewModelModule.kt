package com.cariad.app.di

import com.cariad.app.viewmodels.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        MapsViewModel(get(), get())
    }
}