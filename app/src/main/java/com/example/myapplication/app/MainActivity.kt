package com.example.myapplication.app

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.app.ui.theme.MyApplicationTheme
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.app.navigation.NavHost
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.binding
import dev.zacsweers.metrox.android.ActivityKey
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory
import dev.zacsweers.metrox.viewmodel.MetroViewModelFactory

@Inject
@ContributesIntoMap(AppScope::class, binding<Activity>())
@ActivityKey(MainActivity::class)
class MainActivity(
    private val metroVmf: MetroViewModelFactory,
) : ComponentActivity() {

    override val defaultViewModelProviderFactory: ViewModelProvider.Factory
        get() = metroVmf

    val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(LocalMetroViewModelFactory provides metroVmf) {
                @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
                MyApplicationTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                        NavHost(viewModel.stringFlow.collectAsState().value)
                    }
                }
            }
        }
    }
}
