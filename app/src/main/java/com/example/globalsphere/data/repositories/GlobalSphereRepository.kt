package com.example.globalsphere.data.repositories

import com.example.globalsphere.datasources.remote.dto.CountryInfo
import com.example.globalsphere.datasources.remote.api.GlobalSphereApiService

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 10:00 PM
 */
interface GlobalSphereRepository {
    suspend fun getCountries(): List<CountryInfo>
}

class NetworkGlobalSphereRepository(private val globalSphereApiService: GlobalSphereApiService) :
    GlobalSphereRepository {
    override suspend fun getCountries(): List<CountryInfo> = globalSphereApiService.getCountries()

}