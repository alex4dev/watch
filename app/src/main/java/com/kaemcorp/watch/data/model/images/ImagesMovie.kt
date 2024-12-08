package com.kaemcorp.watch.data.model.images


data class ImagesMovie(
    val backdrops: List<ImageMovie>
) {
    companion object {
        fun fromDto(dto: ImagesMovieDto) = with(dto) {
            ImagesMovie(
                backdrops = backdrops.map { ImageMovie.fromDto(it) }
            )
        }
    }
}

data class ImageMovie(
    val aspectRatio: Double,
    val height: Int,
    val iso6391: String,
    val filePath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val width: Int

) {
    companion object {
        fun fromDto(dto: ImageMovieDto) = with(dto) {
            ImageMovie(
                aspectRatio = aspectRatio,
                height = this.height,
                iso6391 = this.iso6391,
                filePath = this.filePath,
                voteAverage = this.voteAverage,
                voteCount = this.voteCount,
                width = this.width
            )
        }
    }
}