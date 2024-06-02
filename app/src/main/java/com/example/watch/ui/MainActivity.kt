package com.example.watch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.watch.ui.home.HomeScreen
import com.example.watch.ui.theme.WatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val startScreen = HomeScreen()
        setContent {
            WatchTheme {
                Navigator(startScreen)
                {
                    SlideTransition(navigator = it)
                }
            }
        }
    }
}