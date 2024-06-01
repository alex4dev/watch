package com.example.watch.data.model.playingmovies

data class PlayingMovies(
    val dates: PlayingDates,
    val page: Int,
    val results: List<PlayingMovie>,
    val totalPages: Int,
    val totalResults: Int
) {

    companion object {
        fun fromDto(dto: PlayingMoviesDto): PlayingMovies = with(dto) {
            PlayingMovies(
                dates = PlayingDates.fromDto(dates),
                page = page,
                results = results.map { PlayingMovie.fromDto(it) },
                totalPages = totalPages,
                totalResults = totalResults
            )
        }
    }
}

data class PlayingDates(
    val maximum: String,
    val minimum: String
) {

    companion object {
        fun fromDto(dto: PlayingDatesDto): PlayingDates = with(dto) {
            PlayingDates(
                maximum = maximum,
                minimum = minimum
            )
        }
    }
}

data class PlayingMovie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) {

    companion object {
        fun fromDto(dto: PlayingMovieDto): PlayingMovie = with(dto) {
            PlayingMovie(
                adult = adult,
                backdropPath = backdropPath,
                genreIds = genreIds,
                id = id,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                overview = overview,
                popularity = popularity,
                posterPath = posterPath,
                releaseDate = releaseDate,
                title = title,
                video = video,
                voteAverage = voteAverage,
                voteCount = voteCount
            )
        }
    }
}