package com.example.watch.core.di

import com.example.watch.data.services.MoviesService
import com.example.watch.data.sources.movies.MoviesRepository
import com.example.watch.data.sources.movies.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRemoteRepository(get()) }
}

fun provideRemoteRepository(apiService: MoviesService): MoviesRepository {
    return MoviesRepositoryImpl(apiService)
}