package com.example.watch.data.sources.movies

import com.example.watch.data.model.playingmovies.PlayingMovies
import com.example.watch.data.model.playingmovies.PlayingMoviesDto
import com.example.watch.data.services.MoviesService
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(private val service: MoviesService) : MoviesRepository {
    override suspend fun getPlayingMovies(): Result<PlayingMovies> = withContext(Dispatchers.IO) {
        runCatching {
            service.getPlayingMovies().body<PlayingMoviesDto>().let {
                return@withContext Result.success(PlayingMovies.fromDto(it))
            }
        }
    }
}