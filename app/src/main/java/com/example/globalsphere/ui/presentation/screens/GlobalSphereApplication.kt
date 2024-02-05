package com.example.globalsphere.ui.presentation.screens

import android.app.Application
import timber.log.Timber

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 11:05 PM
 */
open class GlobalSphereApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeTimber()
    }

    private fun initializeTimber(){
        Timber.plant(Timber.DebugTree())
    }
}