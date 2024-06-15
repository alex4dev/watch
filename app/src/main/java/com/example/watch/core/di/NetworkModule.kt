package com.example.watch.core.di

import com.example.watch.data.network.httpClientAndroid
import com.example.watch.data.services.MoviesRessourcesService
import com.example.watch.data.services.MoviesService
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