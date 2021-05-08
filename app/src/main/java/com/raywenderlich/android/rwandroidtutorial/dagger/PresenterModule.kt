package com.raywenderlich.android.rwandroidtutorial.dagger

import com.raywenderlich.android.rwandroidtutorial.MainContract
import com.raywenderlich.android.rwandroidtutorial.MainPresenter
import com.raywenderlich.android.rwandroidtutorial.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideMainPresenter(weatherRepo: WeatherRepository): MainContract.Presenter = MainPresenter(weatherRepo)
}