package com.example.globalsphere.ui.screens

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/27/23
 * TIME        : 10:41 PM
 */
sealed class ScreensNav(val route : String){
//    object Countries: ScreensNav(route = "countries_screen")
//    object Country: ScreensNav(route = "country_screen")

    object Home: ScreensNav(route = "countries_screen")
}
