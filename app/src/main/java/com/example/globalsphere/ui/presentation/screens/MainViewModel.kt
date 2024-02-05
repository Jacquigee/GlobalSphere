package com.example.globalsphere.ui.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.domain.repositories.GlobalSphereRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/20/23
 * TIME        : 10:09 PM
 */

sealed interface MainViewModelState {

    data class Countries(
        val name: String,
        val capital: String,
        val flag: String,
    )

    data class Success(val countries: List<Countries>, val selectedCountry: Countries?) :
        MainViewModelState
    object Loading : MainViewModelState
    object Error : MainViewModelState

}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GlobalSphereRepository
): ViewModel() {

    private val _mainViewModelState = MutableLiveData<MainViewModelState>()
    val mainViewModelState: LiveData<MainViewModelState> get() = _mainViewModelState
    init {
        _mainViewModelState.value = MainViewModelState.Loading
        getRestCountries()
    }


 private fun handleSuccess(result: List<MainViewModelState.Countries>){
     val countries = result.map {
         MainViewModelState.Countries(
             it.name,
             it.capital,
             it.flag
         )
     }
     _mainViewModelState.value = MainViewModelState.Success(countries, null)
 }

    private fun handleError(){
        _mainViewModelState.value = MainViewModelState.Error
    }
    fun getRestCountries() {
        viewModelScope.launch {
            try {
                val result = listOf( MainViewModelState.Countries(name = "", capital = "", flag = ""))
                handleSuccess(result)

            } catch (e: IOException) {
                handleError()
            }
        }
    }

    fun selectedCountry(country: MainViewModelState.Countries){
        _mainViewModelState.value = (mainViewModelState as MainViewModelState.Success).copy(selectedCountry = country)
    }

}