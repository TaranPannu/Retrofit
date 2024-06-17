package com.example.weatherapp.di

import com.example.weatherapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Module::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}