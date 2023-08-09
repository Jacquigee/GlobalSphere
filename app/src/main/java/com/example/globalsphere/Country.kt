package com.example.globalsphere

import java.util.jar.Attributes

data class Country(
    val capital: List<String>,
    val continents: List<String>,
    val flag: String,
    val name: Attributes.Name,
    val population: Int,
    val region: String,
    val startOfWeek: String,
    val timezones: List<String>,
    )