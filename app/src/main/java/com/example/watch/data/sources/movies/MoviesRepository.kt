package com.example.watch.data.sources.movies

import com.example.watch.data.model.playingmovies.PlayingMovies

interface MoviesRepository {

    suspend fun getPlayingMovies(): Result<PlayingMovies>
    
}