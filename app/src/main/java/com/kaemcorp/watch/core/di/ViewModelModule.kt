package com.kaemcorp.watch.core.di

import com.kaemcorp.watch.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val viewModelModule = module {
    factoryOf(::HomeViewModel)
}