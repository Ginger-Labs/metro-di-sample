package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.GraphExtension
import dev.zacsweers.metro.Provider
import dev.zacsweers.metro.Provides
import dev.zacsweers.metrox.viewmodel.ManualViewModelAssistedFactory
import dev.zacsweers.metrox.viewmodel.MetroViewModelFactory
import dev.zacsweers.metrox.viewmodel.ViewModelAssistedFactory
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

/**
 * Creates a MetroViewModelFactory from this ViewModelGraph.
 * This allows the graph to be used with LocalMetroViewModelFactory and metroViewModel().
 */
fun HomeViewModelGraph.asMetroViewModelFactory(): MetroViewModelFactory {
    return object : MetroViewModelFactory() {
        override val viewModelProviders: Map<KClass<out ViewModel>, Provider<ViewModel>>
            get() = this@asMetroViewModelFactory.viewModelProviders
        override val assistedFactoryProviders: Map<KClass<out ViewModel>, Provider<ViewModelAssistedFactory>>
            get() = emptyMap()
        override val manualAssistedFactoryProviders: Map<KClass<out ManualViewModelAssistedFactory>, Provider<ManualViewModelAssistedFactory>>
            get() = emptyMap()
    }
}
