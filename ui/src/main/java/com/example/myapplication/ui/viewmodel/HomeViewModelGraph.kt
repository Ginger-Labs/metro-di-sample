package com.example.myapplication.ui.viewmodel

import dev.zacsweers.metro.GraphExtension

@GraphExtension(HomeViewModelScope::class)
interface HomeViewModelGraph {

    val homeViewModelFactory : MetroHomeViewModelFactory
}

data object HomeViewModelScope
