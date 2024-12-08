package com.kaemcorp.watch.core.di

import com.kaemcorp.watch.data.network.httpClientAndroid
import com.kaemcorp.watch.data.services.MoviesRessourcesService
import com.kaemcorp.watch.data.services.MoviesService
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single { provideMoviesService(get()) }
    single { provideHttpClient() }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}

fun provideMoviesService(httpClient: HttpClient): MoviesService {
    return MoviesService(httpClient)
}

fun provideMoviesRessourcesService(httpClient: HttpClient): MoviesRessourcesService {
    return MoviesRessourcesService(httpClient)
}