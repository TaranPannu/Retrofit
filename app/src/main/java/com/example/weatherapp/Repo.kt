package com.example.weatherapp

import javax.inject.Inject

class Repo @Inject constructor(private val retrofitServices: RetrofitServices) {
   suspend fun getWeatherDetail(city: String) = retrofitServices.getWeatherDetail(city)
}