package com.kaemcorp.watch.data.sources.movies

import com.kaemcorp.watch.data.model.images.ImagesMovie

interface MoviesRessourcesRepository {
    suspend fun getImages(movieId: Int): Result<ImagesMovie>

}