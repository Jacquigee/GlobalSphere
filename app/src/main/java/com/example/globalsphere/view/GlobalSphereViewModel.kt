package com.example.globalsphere.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalsphere.network.GlobalSphereAPI
import kotlinx.coroutines.launch

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 10:04 PM
 */
class GlobalSphereViewModel : ViewModel() {

    var globalSphereState: String by mutableStateOf("")
    private set

    init {
        getRestCountries()
    }

    fun getRestCountries(){
       viewModelScope.launch {
           val listResult = GlobalSphereAPI.retrofitService.getCountries()
           globalSphereState = listResult
       }
    }
}