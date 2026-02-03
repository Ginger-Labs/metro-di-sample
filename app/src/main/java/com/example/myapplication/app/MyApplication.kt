package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.app.di.AppGraph
import dev.zacsweers.metro.createGraphFactory
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.android.MetroApplication

class MyApplication : Application(), MetroApplication {
    val appGraph: AppGraph by lazy { createGraphFactory<AppGraph.Factory>().create(this) }
    override val appComponentProviders: MetroAppComponentProviders
        get() = appGraph
}