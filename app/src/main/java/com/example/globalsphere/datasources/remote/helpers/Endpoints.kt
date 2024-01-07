package com.example.globalsphere.datasources.remote.helpers

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Jan, 1/6/24
 * TIME        : 2:32 PM
 */
sealed class Endpoints(private val path: String) {

    val url: String
        get() = buildString {
            append("https://restcountries.com/v3.1/")
            append(path)
        }

    data object Country {
        data object ViewCountry : Endpoints(path = "all")
    }
}