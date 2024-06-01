package com.example.watch.core.di

import com.example.watch.core.network.httpClientAndroid
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