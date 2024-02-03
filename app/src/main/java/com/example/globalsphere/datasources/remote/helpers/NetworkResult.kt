package com.example.globalsphere.datasources.remote.helpers

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/3/24
 * TIME        : 9:19 PM
 */

sealed interface NetworkResult<out T> {
    data class Error(val message: String, val exception: Exception) : NetworkResult<Nothing>
    data class Success<T>(val data: T) : NetworkResult<T>
}