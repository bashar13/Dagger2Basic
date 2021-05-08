/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.rwandroidtutorial

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.rwandroidtutorial.application.UmbrellaApplication
import com.segment.analytics.Analytics
import java.security.AccessController
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
  private lateinit var imageView: ImageView
  private lateinit var button: Button

  @Inject lateinit var presenter:MainContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    (application as UmbrellaApplication).appComponent.inject(this)

    imageView = findViewById(R.id.imageView)
    button = findViewById(R.id.button)

    presenter.setView(this)
    presenter.onViewCreated()

    button.setOnClickListener {
      Analytics.with(this).track("Button Clicked")
      presenter.onLoadWeatherTapped()
    }

  }

  override fun onDestroy() {
    presenter.onDestroy()
    super.onDestroy()
  }

  override fun displayWeatherState(weatherState: WeatherState) {
    val drawable = resources.getDrawable(weatherDrawableResId(weatherState),
            applicationContext.getTheme())
    this.imageView.setImageDrawable(drawable)
  }

  private fun weatherDrawableResId(weatherState: WeatherState) : Int {
    return when (weatherState) {
      WeatherState.SUN -> R.drawable.ic_sun
      WeatherState.RAIN -> R.drawable.ic_umbrella
    }
  }
}

