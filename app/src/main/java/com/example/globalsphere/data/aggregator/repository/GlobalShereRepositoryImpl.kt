package com.example.globalsphere.data.aggregator.repository

import com.example.globalsphere.data.domain.repositories.GlobalSphereRepository
import com.example.globalsphere.datasources.remote.api.GlobalSphereApiService
import com.example.globalsphere.datasources.remote.dto.CountryInfoDTO
import com.example.globalsphere.datasources.remote.helpers.NetworkResult
import javax.inject.Inject

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/4/24
 * TIME        : 6:02 PM
 */
class GlobalShereRepositoryImpl @Inject constructor(
    private val globalSphereApiService: GlobalSphereApiService
) : GlobalSphereRepository {
    override suspend fun getCountries(): NetworkResult<CountryInfoDTO> = globalSphereApiService.getCountries()
}