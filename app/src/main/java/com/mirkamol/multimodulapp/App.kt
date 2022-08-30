package com.mirkamol.multimodulapp

import android.app.Application
import com.mirkamol.multimodulapp.di.AppComponent
import com.mirkamol.multimodulapp.di.DaggerAppComponent
import javax.inject.Inject


class App @Inject constructor(): Application() {
    companion object{
        lateinit var appCompanent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        appCompanent  = DaggerAppComponent
            .factory()
            .create(this)

        appCompanent.inject(this)
    }
}


