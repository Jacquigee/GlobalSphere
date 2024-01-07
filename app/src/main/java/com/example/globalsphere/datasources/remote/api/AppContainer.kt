package com.example.globalsphere.datasources.remote.api

import com.example.globalsphere.data.repositories.GlobalSphereRepository
import com.example.globalsphere.data.repositories.NetworkGlobalSphereRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 10:19 PM
 */
interface AppContainer {
    val globalSphereRepository: GlobalSphereRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://restcountries.com/v3.1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    val retrofitService: GlobalSphereApiService by lazy {
        retrofit.create(GlobalSphereApiService::class.java)
    }
    override val globalSphereRepository: GlobalSphereRepository by lazy {
        NetworkGlobalSphereRepository(retrofitService)
    }
}