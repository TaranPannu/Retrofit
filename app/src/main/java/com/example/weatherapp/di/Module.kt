package com.example.weatherapp.di

import com.example.weatherapp.Repo
import com.example.weatherapp.RetrofitServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)// module only excist till the application excist once the application finish, module will also be destroyed
@Module
class Module {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit
    {
        return Retrofit.Builder().baseUrl("https://api.weatherapi.com").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitServices(retrofit: Retrofit): RetrofitServices
    {
        return retrofit.create(RetrofitServices::class.java)
    }

    @Singleton
    @Provides
    fun providesRepo(retrofitServices: RetrofitServices) : Repo
    {
return Repo(retrofitServices)
    }


}