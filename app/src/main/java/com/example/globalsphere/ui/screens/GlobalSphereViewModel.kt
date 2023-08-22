package com.example.globalsphere.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.globalsphere.GlobalSphereApplication
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

class GlobalSphereViewModel(private val globalSphereRepository: NetworkGlobalSphereRepository) : ViewModel() {

    var globalSphereState: GlobalSphereState by mutableStateOf(GlobalSphereState.Loading)
        private set

    init {
        getRestCountries()
    }

    fun getRestCountries() {
       viewModelScope.launch {
           try {
               val result = globalSphereRepository.getCountries()[0]
               globalSphereState =
                   GlobalSphereState.Success("Success: ${result.name.common} has been retrieved")
           } catch (e: IOException) {
               GlobalSphereState.Error
           }
       }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as GlobalSphereApplication)
                val globalSphereRepository = application.container.globalSphereRepository
                GlobalSphereViewModel(globalSphereRepository = globalSphereRepository as NetworkGlobalSphereRepository)
            }
        }
    }
}

