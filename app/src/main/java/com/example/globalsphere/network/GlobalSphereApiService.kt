package com.example.globalsphere.network

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

private const val BASE_URL = "https://restcountries.com/v3.1/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface GlobalSphereApiService {
    @GET("all")
    suspend fun getCountries(): String

}

object GlobalSphereAPI{
    val retrofitService: GlobalSphereApiService by lazy {
        retrofit.create(GlobalSphereApiService::class.java)
    }
}