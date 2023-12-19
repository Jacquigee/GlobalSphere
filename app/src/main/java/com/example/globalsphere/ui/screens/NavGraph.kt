package com.example.globalsphere.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/27/23
 * TIME        : 11:15 PM
 */

@Composable
fun NavGraph(
    navController: NavHostController,
    state: MainViewModelState,
    countryUpdated: (MainViewModelState.Countries) -> Unit,

) {

    NavHost(
        navController = navController,
        startDestination = ScreensNav.Home.route
    ) {
        composable(route = ScreensNav.Home.route) {
//            HomeScreen(state = state, countryUpdated = countryUpdated)
            //HomeScreen(globalSphereState = )
        }

    }

}