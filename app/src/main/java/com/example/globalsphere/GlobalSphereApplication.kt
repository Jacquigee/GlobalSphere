package com.example.globalsphere

import android.app.Application
import com.example.globalsphere.datasources.remote.api.AppContainer
import com.example.globalsphere.datasources.remote.api.DefaultAppContainer
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 11:05 PM
 */
@HiltAndroidApp
class GlobalSphereApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
        initializeTimber()
    }

    private fun initializeTimber(){
        Timber.plant(Timber.DebugTree())
    }
}