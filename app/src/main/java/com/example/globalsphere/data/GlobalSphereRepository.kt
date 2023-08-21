package com.example.globalsphere.data

import com.example.globalsphere.network.GlobalSphereAPI

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

class NetworkGlobalSphereRepository() : GlobalSphereRepository{
    override suspend fun getCountries(): List<CountryInfo> {
        return GlobalSphereAPI.retrofitService.getCountries()
    }
}