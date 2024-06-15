package com.example.watch.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.example.watch.data.model.playingmovies.PlayingMovie
import com.manpower.interimaires.app.utils.AsyncState


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        CompositionLocalProvider(
            androidx.lifecycle.compose.LocalLifecycleOwner provides androidx.compose.ui.platform.LocalLifecycleOwner.current,
        ) {
            RenderContent()
        }
    }

    @Composable
    private fun RenderContent(modifier: Modifier = Modifier) {

        val uiState: State<HomeUiState> =
            koinScreenModel<HomeViewModel>().uiState.collectAsStateWithLifecycle()




        when (uiState.value.playingMovies) {
            is AsyncState.Success -> {
                RenderMovies((uiState.value.playingMovies.getOrNull() ?: emptyList()))
            }

            else -> Unit
        }

    }


    @Composable
    private fun RenderMovies(movies: List<PlayingMovie>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) {
                MovieCard(it, Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    private fun MovieCard(item: PlayingMovie, modifier: Modifier = Modifier) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ), modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
        ) {
            Column {
                Text(text = item.title, modifier = Modifier.padding(16.dp))
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewMovieCard() {
        MovieCard(item = PlayingMovie())
    }


}