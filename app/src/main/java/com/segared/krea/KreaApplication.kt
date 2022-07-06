package com.segared.krea

import android.app.Application
import com.segared.krea.utils.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KreaApplication : Application() {

    companion object {
        lateinit var prefs : Prefs
    }

    override fun onCreate() {
        super.onCreate()

        prefs = Prefs(applicationContext)
    }

}