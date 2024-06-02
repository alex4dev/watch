package com.example.watch.core.di

import com.example.watch.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val viewModelModule = module {
    factoryOf(::HomeViewModel)
}