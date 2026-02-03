package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.zacsweers.metrox.viewmodel.metroViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appName: String,
    viewModel: HomeViewModel = metroViewModel(),
) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Hello(viewModel.name.value)
        AppIntro(appName)
    }
}

@Composable
fun Hello(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun AppIntro(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
