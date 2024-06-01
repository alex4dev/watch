package com.example.watch.core.network

import com.example.watch.core.END_POINT

object ApiRoutes {
    private const val VERSION_PATH = "/3"
    private const val MOVIE_PATH = "/movie"

    const val MOVIES_PLAYING_ENDPOINT = "$END_POINT$VERSION_PATH$MOVIE_PATH/now_playing"
}