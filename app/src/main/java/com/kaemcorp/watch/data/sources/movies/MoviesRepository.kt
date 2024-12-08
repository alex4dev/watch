package com.kaemcorp.watch.data.sources.movies

import com.kaemcorp.watch.data.model.playingmovies.PlayingMovies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPlayingMoviesStream(): Flow<Result<PlayingMovies>>
    suspend fun getPlayingMovies(): Result<PlayingMovies>

}