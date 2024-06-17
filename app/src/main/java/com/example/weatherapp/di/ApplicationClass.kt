package com.example.weatherapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerCollections
import dagger.internal.DaggerGenerated

class ApplicationClass: Application() {
lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
    applicationComponent = DaggerApplicationComponent.builder().build()
    }
}

