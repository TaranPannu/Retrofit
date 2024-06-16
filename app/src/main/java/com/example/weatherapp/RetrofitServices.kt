package com.example.weatherapp

import com.example.weatherapp.datamodel.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("/v1/current.json?key=a5c14498905d4d08a00164557241406")
  suspend fun getWeatherDetail(@Query("q") city:String) : Response<WeatherResponseModel>
}