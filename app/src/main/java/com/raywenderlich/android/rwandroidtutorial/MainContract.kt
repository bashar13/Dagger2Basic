package com.raywenderlich.android.rwandroidtutorial

interface MainContract {

    interface Presenter : BasePresenter<View> {
        fun onViewCreated()
        fun onLoadWeatherTapped()
    }

    interface View {
        fun displayWeatherState(weatherState: WeatherState)
    }
}