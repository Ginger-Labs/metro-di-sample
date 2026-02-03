package com.example.myapplication.app

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.home.HomeStateRepository
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey

@Inject
@ViewModelKey(MainActivityViewModel::class)
@ContributesIntoMap(AppScope::class)
class MainActivityViewModel(
    homeStateRepository: HomeStateRepository
) : ViewModel() {
    val stringFlow = homeStateRepository.stringFlow
}