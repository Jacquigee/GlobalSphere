package com.example.globalsphere.datasources.remote.helpers

import timber.log.Timber

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/3/24
 * TIME        : 9:10 PM
 */

suspend fun <T> safeApiCall(errorMessage: String = "", block: suspend () -> T): NetworkResult<T> {
    return try {
        val data = block.invoke()
        NetworkResult.Success(data = data)
    } catch (e: Exception) {
        Timber.e(e)
        NetworkResult.Error(message = e.localizedMessage ?: errorMessage, exception = e)
    }
}