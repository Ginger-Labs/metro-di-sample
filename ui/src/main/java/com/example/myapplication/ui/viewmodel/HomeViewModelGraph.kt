package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.viewmodel.CreationExtras
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provides

@GraphExtension(HomeViewModelScope::class)
interface HomeViewModelGraph {

    @GraphExtension.Factory
    @ContributesTo(AppScope::class)
    interface Factory {
        fun createHomeViewModelGraph(
            @Provides creationExtras: CreationExtras,
        ): HomeViewModelGraph
    }
}

data object HomeViewModelScope
