package com.example.watch.data.network

object ApiRoutes {
    const val API_BASE_URL = "https://api.themoviedb.org"
    private const val IMAGE_BASE_URL = "https://image.tmdb.org"

    private const val VERSION_PATH = "/3"
    private const val MOVIE_PATH = "/movie"

    const val MOVIE_BASE_ENDPOINT = "$API_BASE_URL$VERSION_PATH$MOVIE_PATH"

    const val MOVIES_PLAYING_ENDPOINT = "$API_BASE_URL$VERSION_PATH$MOVIE_PATH/now_playing"
    const val IMAGE_ORIGINAL_ENDPOINT = "$IMAGE_BASE_URL/t/p/original"


    fun buildImagesUrl(id: Int) = "$MOVIE_BASE_ENDPOINT/$id/images"
}
