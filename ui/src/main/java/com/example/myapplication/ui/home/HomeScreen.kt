package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.myapplication.ui.viewmodel.HomeViewModelGraph
import dev.zacsweers.metro.asContribution
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory
import dev.zacsweers.metrox.viewmodel.metroViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appName: String,
    homeViewModelGraph: HomeViewModelGraph,
) {
    // Get the ViewModel from the scoped graph's provider map
    // This ViewModel is ONLY available within HomeViewModelScope
    // Code outside this scope cannot access it
    val viewModel = remember(homeViewModelGraph) {
        val provider = homeViewModelGraph.viewModelProviders[HomeViewModel::class]
            ?: error("HomeViewModel not found in HomeViewModelScope")
        provider() as HomeViewModel
    }

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
