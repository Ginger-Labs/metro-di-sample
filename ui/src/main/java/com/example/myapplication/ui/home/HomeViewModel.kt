package com.example.myapplication.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.viewmodel.HomeViewModelScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.binding
import dev.zacsweers.metrox.viewmodel.ViewModelKey

@Inject
@ViewModelKey(HomeViewModel::class)
@ContributesIntoMap(HomeViewModelScope::class, binding<ViewModel>())
class HomeViewModel : ViewModel() {
    val name = mutableStateOf("Name")
}