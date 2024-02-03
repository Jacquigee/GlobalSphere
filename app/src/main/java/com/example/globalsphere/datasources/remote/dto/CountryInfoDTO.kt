package com.example.globalsphere.datasources.remote.dto

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

@Serializable
data class CountryName(
    val common: String,
    val official: String
)

@Serializable
data class CoatOfArms(
    val png: String,
    val svg: String
)

