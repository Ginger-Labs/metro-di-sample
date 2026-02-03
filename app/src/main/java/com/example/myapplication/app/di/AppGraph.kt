package com.example.myapplication.app.di

import android.content.Context
import com.example.myapplication.data.di.ApplicationContext
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.viewmodel.ViewModelGraph

@DependencyGraph(scope = AppScope::class)
interface AppGraph : MetroAppComponentProviders, ViewModelGraph {

    val metroActivityViewModelFactory: MetroActivityViewModelFactory

    @DependencyGraph.Factory
    interface Factory {
        fun create(@Provides @ApplicationContext context: Context): AppGraph
    }
}