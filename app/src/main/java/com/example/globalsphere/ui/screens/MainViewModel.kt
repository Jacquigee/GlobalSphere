package com.example.globalsphere.ui.screens

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.AppContainer
import com.example.globalsphere.data.DefaultAppContainer
import com.example.globalsphere.data.GlobalSphereRepository
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
    data class Success(val countries: List<Countries>, val selectedCountry: Countries?) : MainViewModelState
    object Loading : MainViewModelState
    object Error :  MainViewModelState

    data class Countries(
        val name: String,
        val capital: String,
        val flag: String,


        )

}

class MainViewModel(val app: Application) : AndroidViewModel(app) {

    private val container: AppContainer = DefaultAppContainer()
    private val repository: GlobalSphereRepository = container.globalSphereRepository
    var mainViewModelState: MainViewModelState by mutableStateOf(MainViewModelState.Loading)
        private set

    init {
        getRestCountries()
    }

    fun getRestCountries() {
        viewModelScope.launch {
            try {
                val result = repository.getCountries()
                mainViewModelState =
                    MainViewModelState.Success( countries = result.map { MainViewModelState.Countries(it.name.common, it.capital?.joinToString { it }?:" ", it.flag) }, null)

            } catch (e: IOException) {
                MainViewModelState.Error
            }
        }
    }

    fun selectedCountry(country: MainViewModelState.Countries){
        mainViewModelState = (mainViewModelState as MainViewModelState.Success).copy(selectedCountry = country)
    }

}