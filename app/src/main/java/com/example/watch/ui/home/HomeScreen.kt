package com.example.watch.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        RenderContent()
    }

    @Composable
    private fun RenderContent(modifier: Modifier = Modifier) {
        val viewModel: HomeViewModel = koinScreenModel()
        LazyColumn {
            items(100) {
                MovieCard(it, Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    private fun MovieCard(item: Int, modifier: Modifier = Modifier) {
        Card(modifier = modifier.fillMaxWidth()) {
            Column {
                Text(text = "Item $item", modifier = Modifier.padding(16.dp))
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewMovieCard() {
        MovieCard(item = 1)
    }


}