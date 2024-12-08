package com.kaemcorp.watch.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import coil3.compose.AsyncImage
import com.kaemcorp.watch.data.model.playingmovies.PlayingMovie
import com.manpower.interimaires.app.utils.AsyncState


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        CompositionLocalProvider(
            androidx.lifecycle.compose.LocalLifecycleOwner provides androidx.compose.ui.platform.LocalLifecycleOwner.current,
        ) {
            HomeContent()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HomeContent(modifier: Modifier = Modifier) {

        val uiState: State<HomeUiState> =
            koinScreenModel<HomeViewModel>().uiState.collectAsStateWithLifecycle()

        Scaffold(modifier = modifier, topBar = {
            TopAppBar(title = { Text(text = "Watch") })
        }) {
            when (uiState.value.playingMovies) {
                is AsyncState.Loading -> LoadingContent()
                is AsyncState.Success -> {
                    MoviesContent(
                        (uiState.value.playingMovies.getOrNull() ?: emptyList()),
                        Modifier.padding(it)
                    )
                }

                else -> Unit
            }
        }
    }

    @Composable
    private fun LoadingContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    @Composable
    private fun MoviesContent(movies: List<PlayingMovie>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) {
                MovieListItem(it, Modifier.padding(8.dp), onClick = {})
            }
        }
    }

    @Composable
    private fun MovieListItem(
        item: PlayingMovie,
        modifier: Modifier = Modifier,
        onClick: () -> Unit
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp),
            onClick = onClick
        ) {
            Column {
                AsyncImage(
                    model = item.posterUrl,
                    contentDescription = null,
                )
                Text(text = item.title, modifier = Modifier.padding(16.dp))
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewMovieCard() {
        MovieListItem(item = PlayingMovie(), onClick = {})
    }


}