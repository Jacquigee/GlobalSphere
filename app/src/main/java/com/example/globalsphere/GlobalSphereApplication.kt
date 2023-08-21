package com.example.globalsphere

import android.app.Application
import com.example.globalsphere.data.AppContainer
import com.example.globalsphere.data.DefaultAppContainer

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 11:05 PM
 */
class GlobalSphereApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}