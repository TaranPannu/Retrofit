package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.weatherapp.di.ApplicationClass
import org.w3c.dom.Text
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory
    private lateinit var weatherViewModel: WeatherViewModel

    //    private lateinit var repo: Repo
    private lateinit var loader: ProgressBar

    private lateinit var editCityName: EditText
    private lateinit var btnGetWeather: Button
    private lateinit var imgWeather: ImageView
    private lateinit var textWeather:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//loader.visibility=View.GONE
        (application as ApplicationClass).applicationComponent.inject(this)
        init()
        btnGetWeather.setOnClickListener {
            weatherViewModel.getWeatherDetail(editCityName.text.toString())
        }
//        val cityName = "Delhi"
//        weatherViewModel.getWeatherDetail(cityName)

        weatherViewModel.weatherDetailLiveData.observe(this)
        {
            val currentWeatherType = it.current.condition.text
            val currentTempInC = it.current.temp_c

            textWeather.text = "$currentWeatherType, $currentTempInC"

            val imagelink = "https:${it.current.condition.icon}"
            Glide.with(this).load(imagelink).into(imgWeather)

            val cityname = it.location.name
            val state = it.location.region

            Log.d("WeatherDetail",imagelink)
        }

        weatherViewModel.isLoading.observe(this)
        {
            if(it)
            {
                loader.visibility = View.VISIBLE
            }
            else
            {
                loader.visibility = View.GONE

            }
        }

    }
    private fun init()
    {
//        repo = Repo(RetrofitBuilder.getInstance())
//        weatherViewModelFactory = WeatherViewModelFactory(repo)
        weatherViewModel = ViewModelProvider(this, weatherViewModelFactory).get(WeatherViewModel::class.java)
        loader =findViewById(R.id.progBar)

        editCityName = findViewById<EditText>(R.id.city_name)
        btnGetWeather = findViewById(R.id.btn)
        imgWeather = findViewById(R.id.Img)
        textWeather = findViewById(R.id.txt_vw)
    }
}