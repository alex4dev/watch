package com.kaemcorp.watch.data.services

import com.kaemcorp.watch.core.ApiRoutes
import io.ktor.client.HttpClient
import io.ktor.client.request.get


class MoviesService(private val client: HttpClient) {

    suspend fun getPlayingMovies() = client.get(ApiRoutes.MOVIES_PLAYING_ENDPOINT)

}