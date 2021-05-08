package com.raywenderlich.android.rwandroidtutorial.dagger

import com.raywenderlich.android.rwandroidtutorial.MainActivity
import com.raywenderlich.android.rwandroidtutorial.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [AppModule::class, WeatherRepoModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(target:MainActivity)
}