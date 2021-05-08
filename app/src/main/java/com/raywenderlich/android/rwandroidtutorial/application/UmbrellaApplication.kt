package com.raywenderlich.android.rwandroidtutorial.application

import android.app.Application
import com.raywenderlich.android.rwandroidtutorial.dagger.AppComponent
import com.raywenderlich.android.rwandroidtutorial.dagger.AppModule
import com.raywenderlich.android.rwandroidtutorial.dagger.DaggerAppComponent
import com.segment.analytics.Analytics

class UmbrellaApplication: Application() {
    lateinit var appComponent: AppComponent

    //Analytics.setSingletonInstance(analytics)

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)

        val analytics = Analytics.Builder(this, "waLo6EpA5bGK424QNzkN65FyDCFjkMcb")
                .trackApplicationLifecycleEvents() // Enable this to record certain application events automatically!
                .recordScreenViews() // Enable this to record screen views automatically!
                .build()

        // Set the initialized instance as a globally accessible instance.
        Analytics.setSingletonInstance(analytics)
    }

    private fun initDagger(app: UmbrellaApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}