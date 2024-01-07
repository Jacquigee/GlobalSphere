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
import com.example.globalsphere.data.repositories.NetworkGlobalSphereRepository
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
    data class Success(val countries: List<Countries>) : GlobalSphereState
    object Loading : GlobalSphereState
    object Error : GlobalSphereState

    data class Countries(
        val name: String,
        val capital: String,
        val flag: String,


    )

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
               val result = globalSphereRepository.getCountries()
               globalSphereState =
                   GlobalSphereState.Success( countries = result.map { GlobalSphereState.Countries(it.name.common, it.capital?.joinToString { it }?:" ", it.flag) })

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

