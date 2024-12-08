package com.kaemcorp.watch.data.services

import com.kaemcorp.watch.core.ApiRoutes
import io.ktor.client.HttpClient
import io.ktor.client.request.get


class MoviesRessourcesService(private val client: HttpClient) {

    suspend fun getImages(id: Int) = client.get(ApiRoutes.buildImagesUrl(id))

}