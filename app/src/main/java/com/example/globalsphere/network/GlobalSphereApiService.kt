package com.example.globalsphere.network

import com.example.globalsphere.data.CountryInfo
import com.example.globalsphere.di.modules.NetworkingCountry
import com.example.globalsphere.network.GlobalSphereAPI.retrofit
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/13/23
 * TIME        : 10:50 PM
 */


interface GlobalSphereApiService {
    @GET("all")
    suspend fun getCountries(): Response<List<CountryInfo>>

}

object GlobalSphereAPI : NetworkingCountry() {
    val retrofitService: GlobalSphereApiService by lazy {
        retrofit.create(GlobalSphereApiService::class.java)
    }
}