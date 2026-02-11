package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provider
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.viewmodel.ViewModelGraph
import kotlin.reflect.KClass

@GraphExtension(HomeViewModelScope::class)
interface HomeViewModelGraph : ViewModelGraph {
    // Expose the ViewModel providers from this scoped graph
    // Only ViewModels in HomeViewModelScope will be available here
    override val viewModelProviders: Map<KClass<out ViewModel>, Provider<ViewModel>>

    @GraphExtension.Factory
    @ContributesTo(AppScope::class)
    interface Factory {
        fun createHomeViewModelGraph(
            @Provides creationExtras: CreationExtras,
        ): HomeViewModelGraph
    }
}

data object HomeViewModelScope
