package com.example.globalsphere.data.domain.repositories

import com.example.globalsphere.datasources.remote.dto.CountryInfoDTO
import com.example.globalsphere.datasources.remote.helpers.NetworkResult

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/21/23
 * TIME        : 10:00 PM
 */
interface GlobalSphereRepository {
    suspend fun getCountries(): NetworkResult<CountryInfoDTO>
}
