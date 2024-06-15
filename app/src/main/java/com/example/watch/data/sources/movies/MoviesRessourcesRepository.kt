package com.example.watch.data.sources.movies

import com.example.watch.data.model.images.ImagesMovie

interface MoviesRessourcesRepository {
    suspend fun getImages(movieId: Int): Result<ImagesMovie>

}