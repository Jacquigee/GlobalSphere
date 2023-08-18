package com.example.globalsphere.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.data.CountryInfo
import com.example.globalsphere.network.GlobalSphereAPI
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 10:04 PM
 */
class GlobalSphereViewModel : ViewModel() {

    //    var globalSphereState: Response<List<CountryInfo>> by mutableStateListOf<>(List<CountryInfo>)
//    var globalSphereState by mutableStateOf(listOf(CountryInfo))
//        private set

    init {
        getRestCountries()
    }

    fun getRestCountries(){
       viewModelScope.launch {
           val listResult = GlobalSphereAPI.retrofitService.getCountries()
//           globalSphereState = listResult
       }
    }
}