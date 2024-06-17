package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.datamodel.WeatherResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val repo: Repo):
    ViewModel()
{
    val weatherDetailLiveData = MutableLiveData<WeatherResponseModel>()
    val isLoading = MutableLiveData<Boolean>(false)


    fun getWeatherDetail(city:String)
            {
          viewModelScope.launch(Dispatchers.IO) {
              // Network request is sent make loader visible
              isLoading.postValue(true)
                val response = repo.getWeatherDetail(city)
                if (response.isSuccessful)
                {
                    weatherDetailLiveData.postValue(response.body())
                }
              // we have the response from the server
              isLoading.postValue(false)

          }
          }

}