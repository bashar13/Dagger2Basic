package com.raywenderlich.android.rwandroidtutorial.dagger

import com.raywenderlich.android.rwandroidtutorial.WeatherRepository
import com.raywenderlich.android.rwandroidtutorial.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherRepoModule {
    @Provides
    @Singleton
    fun provideWeatherRepo():WeatherRepository = WeatherRepositoryImpl()
}