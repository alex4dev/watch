package com.kaemcorp.watch.data.sources.movies

import com.kaemcorp.watch.data.model.images.ImagesMovie
import com.kaemcorp.watch.data.model.images.ImagesMovieDto
import com.kaemcorp.watch.data.services.MoviesRessourcesService
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRessourcesRepositoryImpl(private val service: MoviesRessourcesService) :
    MoviesRessourcesRepository {


    override suspend fun getImages(movieId: Int): Result<ImagesMovie> =
        withContext(Dispatchers.IO) {
            runCatching {
                service.getImages(movieId).body<ImagesMovieDto>().let {
                    return@withContext Result.success(ImagesMovie.fromDto(it))
                }
            }
        }
}