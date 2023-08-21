package com.example.globalsphere.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.NetworkGlobalSphereRepository
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 10:04 PM
 */

sealed interface GlobalSphereState {
    data class Success(val countries: String) : GlobalSphereState
    object Loading : GlobalSphereState
    object Error : GlobalSphereState
}

class GlobalSphereViewModel : ViewModel() {

    var globalSphereState: GlobalSphereState by mutableStateOf(GlobalSphereState.Loading)
        private set

    init {
        getRestCountries()
    }

    fun getRestCountries() {
       viewModelScope.launch {
           try {
               val globalSphereRepository = NetworkGlobalSphereRepository(retrofitService)
               val listResult = globalSphereRepository.getCountries()
               globalSphereState =
                   GlobalSphereState.Success("Success: ${listResult.size} Countries retrieved")
           } catch (e: IOException) {
               GlobalSphereState.Error
           }
       }
    }
}

