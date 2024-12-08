package com.kaemcorp.watch.core.di

import com.kaemcorp.watch.data.services.MoviesRessourcesService
import com.kaemcorp.watch.data.services.MoviesService
import com.kaemcorp.watch.data.sources.movies.MoviesRepository
import com.kaemcorp.watch.data.sources.movies.MoviesRepositoryImpl
import com.kaemcorp.watch.data.sources.movies.MoviesRessourcesRepository
import com.kaemcorp.watch.data.sources.movies.MoviesRessourcesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { provideMoviesRepository(get()) }
    single { provideMoviesRessourcesRepository(get()) }
}

fun provideMoviesRepository(apiService: MoviesService): MoviesRepository {
    return MoviesRepositoryImpl(apiService)
}

fun provideMoviesRessourcesRepository(apiService: MoviesRessourcesService): MoviesRessourcesRepository {
    return MoviesRessourcesRepositoryImpl(apiService)
}