package com.example.watch.data.model.images

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesMovieDto(
    @SerialName("backdrops") val backdrops: List<ImageMovieDto>
)

@Serializable
data class ImageMovieDto(
    @SerialName("aspect_ratio") val aspectRatio: Double,
    @SerialName("height") val height: Int,
    @SerialName("iso_639_1") val iso6391: String,
    @SerialName("file_path") val filePath: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("width") val width: Int
)