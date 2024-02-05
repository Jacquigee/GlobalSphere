package com.example.globalsphere.datasources.remote.api

import com.example.globalsphere.datasources.remote.dto.CountryInfoDTO
import com.example.globalsphere.datasources.remote.helpers.Endpoints
import com.example.globalsphere.datasources.remote.helpers.NetworkResult
import com.example.globalsphere.datasources.remote.helpers.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import timber.log.Timber
import javax.inject.Inject

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/4/24
 * TIME        : 2:30 PM
 */

class GlobalSphereApiImpl @Inject constructor(
    private val client: HttpClient
) : GlobalSphereApiService {
    override suspend fun getCountries(): NetworkResult<CountryInfoDTO> =
        safeApiCall(errorMessage = "Failed fetching Countries") {
            val response = client.get{
              url ( urlString = Endpoints.Country.ViewCountry.url)
        }
        Timber.d("RESPONSE -> \n{response.bodyAsText}")
        response.body()
    }

}