package com.example.globalsphere.datasources.remote.api

import com.example.globalsphere.datasources.remote.dto.CountryInfoDTO
import com.example.globalsphere.datasources.remote.helpers.NetworkResult
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
    suspend fun getCountries(): NetworkResult<CountryInfoDTO>

}