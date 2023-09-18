package com.example.globalsphere.data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CountryInfo(
    @Contextual val name: CountryName,
    val capital: List<String>,
    val continents: List<String>,
    val flag: String,
    val population: Int,
    val region: String,
    val startOfWeek: String,
    val timezones: List<String>,
    @Contextual val coatOfArms: CoatOfArms
)