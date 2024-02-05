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

@HiltViewModel
class GlobalSphereViewModel @Inject constructor(
    private val globalSphereRepository: GlobalShereRepositoryImpl
) : ViewModel() {

    private val _globalSphereState = MutableLiveData<GlobalSphereState>()
    val globalSphereState: LiveData<GlobalSphereState> get() = _globalSphereState


    init {
        _globalSphereState.value = GlobalSphereState.Loading
        getRestCountries()
    }


    private fun handleSuccess(result: List<GlobalSphereState.Countries>) {
        val countries = result.map {
            GlobalSphereState.Countries(
                it.name,
                it.capital,
                it.flag
            )
        }
        _globalSphereState.value = GlobalSphereState.Success(countries)
    }

    private fun handleError() {
        _globalSphereState.value = GlobalSphereState.Error
    }

    fun getRestCountries() {
        viewModelScope.launch {
            try {
                val result = listOf(GlobalSphereState.Countries(name = "", capital = "", flag = ""))
                handleSuccess(result)

            } catch (e: IOException) {
                handleError()
            }
        }
    }
}

//    companion object{
//        val Factory : ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as GlobalSphereApplication)
//                val globalSphereRepository = application.container.globalSphereRepository
//                GlobalSphereViewModel(globalSphereRepository = globalSphereRepository as GlobalShereRepositoryImpl)
//            }
//        }
//    }
//}

