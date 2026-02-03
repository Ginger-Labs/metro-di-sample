package com.example.myapplication.data.home

import android.content.Context
import com.example.myapplication.data.di.ApplicationContext
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.SingleIn
import kotlinx.coroutines.flow.MutableStateFlow

@Inject
@SingleIn(AppScope::class)
class HomeStateRepository(
    @ApplicationContext private val applicationContext: Context,
) {
    val stringFlow = MutableStateFlow(applicationContext.getString(R.string.home_name))
}