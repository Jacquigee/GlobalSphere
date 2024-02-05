package com.example.globalsphere.ui.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.aggregator.repository.GlobalShereRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/20/23
 * TIME        : 5:43 AM
 */

sealed interface GlobalSphereDetailsState {

    data class Success(val countryDetails: List<CountryDetails>) :
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

@HiltViewModel
class GlobalSphereViewModelDetails @Inject constructor(
    private val globalSphereRepository: GlobalShereRepositoryImpl
) : ViewModel() {
    private val _globalSphereDetailsState = MutableLiveData<GlobalSphereDetailsState>()
    val globalSphereDetailsState: LiveData<GlobalSphereDetailsState> get() = _globalSphereDetailsState


    init {
        _globalSphereDetailsState.value = GlobalSphereDetailsState.Loading
        getRestCountryDetails()
    }

    private fun handleSuccess(result: List<GlobalSphereDetailsState.CountryDetails>) {
        val countryDetails = result.map {
            GlobalSphereDetailsState.CountryDetails(
                it.name,
                it.capital,
                it.flag,
                it.population,
                it.region,
                it.startOfWeek,
                it.coatOfArms,
                it.timezones
            )
        }
        _globalSphereDetailsState.value = GlobalSphereDetailsState.Success(countryDetails)
    }

    private fun handleError() {
        _globalSphereDetailsState.value = GlobalSphereDetailsState.Error
    }

    fun getRestCountryDetails() {
        viewModelScope.launch {
            try {
                val result = listOf(
                    GlobalSphereDetailsState.CountryDetails(
                        name = "",
                        capital = "",
                        flag = "",
                        population = 0,
                        region = "",
                        startOfWeek = "",
                        coatOfArms = "",
                        timezones = listOf()
                    )
                )
                handleSuccess(result)

            } catch (e: IOException) {
                handleError()
            }
        }
    }
}
