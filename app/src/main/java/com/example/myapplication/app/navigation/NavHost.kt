package com.example.myapplication.app.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.ui.home.HomeScreen
import kotlinx.serialization.Serializable

@Composable
internal fun NavHost(
    name: String,
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(LoadingRoute)

    LaunchedEffect(null) {
        val startingRoute = HomeRoute
        if (backStack.contains(startingRoute)) {
            backStack[0] = startingRoute
        } else {
            backStack.add(0, startingRoute)
        }
        backStack.remove(LoadingRoute)
    }

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        sceneStrategy = DialogSceneStrategy(),
        entryDecorators =
            listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
        entryProvider =
            entryProvider {
                entry<LoadingRoute> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                entry<HomeRoute> {
                    HomeScreen(appName = name)
                }
            },
        predictivePopTransitionSpec = {
            ContentTransform(
                // Copied from default
                fadeIn(spring(dampingRatio = 1.0f, stiffness = 1600.0f)),
                // Copied from default + fadeOut()
                scaleOut(targetScale = 0.7f) + fadeOut(),
            )
        },
    )
}

@Serializable data object LoadingRoute : NavKey

@Serializable data object HomeRoute : NavKey
