package com.example.globalsphere.datasources.remote.api

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 10:19 PM
 */
//interface AppContainer {
//    val globalSphereRepository: GlobalSphereRepository
//}
//
//class DefaultAppContainer : AppContainer {
//    //Retrofit
//    private val baseUrl = "https://restcountries.com/v3.1/"
//
//    private val retrofit = Retrofit.Builder()
//        .addConverterFactory(MoshiConverterFactory.create())
//        .baseUrl(baseUrl)
//        .build()
//
//    val retrofitService: GlobalSphereApiService by lazy {
//        retrofit.create(GlobalSphereApiService::class.java)
//    }
//    override val globalSphereRepository: GlobalSphereRepository by lazy {
//        NetworkGlobalSphereRepository(retrofitService)
//    }
//}