package com.example.globalsphere.network

import com.example.globalsphere.data.CountryInfo
import com.example.globalsphere.di.modules.NetworkingCountry
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
    suspend fun getCountries(): List<CountryInfo>

}
object GlobalSphereAPI : NetworkingCountry() {
    val retrofitService: GlobalSphereApiService by lazy {
        retrofit.create(GlobalSphereApiService::class.java)
    }
}