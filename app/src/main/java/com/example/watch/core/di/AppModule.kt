package com.example.watch.core.di

import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule, networkModule, repositoryModule)
}
