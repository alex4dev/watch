package com.kaemcorp.watch.ui.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.kaemcorp.watch.data.model.playingmovies.PlayingMovie
import com.kaemcorp.watch.data.sources.movies.MoviesRepository
import com.manpower.interimaires.app.utils.AsyncState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transformLatest

data class HomeUiState(
    val playingMovies: AsyncState<List<PlayingMovie>> = AsyncState.Loading(),
)

class HomeViewModel(private val moviesRepository: MoviesRepository) : ScreenModel {

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<HomeUiState> =
        moviesRepository.getPlayingMoviesStream().transformLatest { result ->

            result.onSuccess { movies ->
                emit(HomeUiState(playingMovies = AsyncState.Success(movies.results)))
            }.onFailure { t ->
                emit(HomeUiState(playingMovies = AsyncState.Failure(t as Exception)))
            }

        }.stateIn(screenModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())

}