package com.example.globalsphere.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.repositories.NetworkGlobalSphereRepository
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/20/23
 * TIME        : 5:43 AM
 */

sealed interface GlobalSphereDetailsState {

    data class Success(val countryDetails: List<GlobalSphereDetailsState.CountryDetails>) :
        GlobalSphereDetailsState

    object Loading : GlobalSphereDetailsState
    object Error : GlobalSphereDetailsState

    data class CountryDetails(
        val name: String,
        val capital: String,
        val flag: String,
        val population: Int,
        val region: String,
        val startOfWeek: String,
        val coatOfArms: String,
        val timezones: List<String>
    )
}

class GlobalSphereViewModelDetails
    (private val globalSphereRepository: NetworkGlobalSphereRepository) : ViewModel() {
    var globalSphereDetailsState: GlobalSphereDetailsState by mutableStateOf(
        GlobalSphereDetailsState.Loading
    )
        private set

    init {
        getRestCountries()
    }

    fun getRestCountries() {
        viewModelScope.launch {
            try {
                val result = globalSphereRepository.getCountries()
                globalSphereDetailsState =
                    GlobalSphereDetailsState.Success(countryDetails = result.map {
                        GlobalSphereDetailsState.CountryDetails(
                            it.name.common,
                            it.capital?.joinToString { it } ?: " ",
                            it.flag,
                            it.population,
                            it.region,
                            it.startOfWeek,
                            it.coatOfArms.png,
                            it.timezones
                        )
                    })

            } catch (e: IOException) {
                GlobalSphereDetailsState.Error
            }
        }
    }
}
