package com.example.watch.data.services

import com.example.watch.core.ApiRoutes
import io.ktor.client.HttpClient
import io.ktor.client.request.get


class MoviesService(private val client: HttpClient) {

    suspend fun getPlayingMovies() = client.get(ApiRoutes.MOVIES_PLAYING_ENDPOINT)

}