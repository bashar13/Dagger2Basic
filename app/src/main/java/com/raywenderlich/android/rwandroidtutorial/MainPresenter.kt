package com.raywenderlich.android.rwandroidtutorial

import com.segment.analytics.Analytics
import java.security.AccessController.getContext
import javax.inject.Inject

class MainPresenter @Inject constructor(weatherRepo: WeatherRepository): MainContract.Presenter {

    private val weatherRepository: WeatherRepository = weatherRepo
    private var view:MainContract.View? = null

    private fun loadWeather() {
        val weather = weatherRepository.loadWeather()
        val weatherState = weatherStateForWeather(weather)
        view?.displayWeatherState(weatherState)
    }

    @Override
    override fun setView(view: MainContract.View) {
        this.view = view
    }

    private fun weatherStateForWeather(weather: Weather) : WeatherState {
        if (weather.rain!!.amount!! > 0) {
            return WeatherState.RAIN
        }
        return WeatherState.SUN
    }
    override fun onViewCreated() {
        loadWeather()
    }

    override fun onLoadWeatherTapped() {
        loadWeather()
    }

    override fun onDestroy() {
        this.view = null
    }

}