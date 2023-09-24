package com.example.globalsphere.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
 * DATE        : Sept, 9/20/23
 * TIME        : 10:09 PM
 */

sealed interface MainViewModelState {
    data class Success(val countries: List<Countries>) : MainViewModelState
    object Loading : MainViewModelState
    object Error :  MainViewModelState

    data class Countries(
        val name: String,
        val capital: String,
        val flag: String,


        )

}
class MainViewModel(private val globalSphereRepository: NetworkGlobalSphereRepository) : ViewModel() {
    var mainViewModelState: MainViewModelState by mutableStateOf(MainViewModelState.Loading)
        private set

    init {
        getRestCountries()
    }
    fun getRestCountries() {
        viewModelScope.launch {
            try {
                val result = globalSphereRepository.getCountries()
                mainViewModelState =
                    MainViewModelState.Success( countries = result.map { MainViewModelState.Countries(it.name.common, it.capital?.joinToString { it }?:" ", it.flag) })

            } catch (e: IOException) {
                MainViewModelState.Error
            }
        }
    }

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GlobalSphereApplication)
                val globalSphereRepository = application.container.globalSphereRepository
                MainViewModel(globalSphereRepository = globalSphereRepository as NetworkGlobalSphereRepository)
            }
        }
    }
}