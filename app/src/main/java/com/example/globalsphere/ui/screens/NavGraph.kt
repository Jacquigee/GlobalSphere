package com.example.globalsphere.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.globalsphere.view.HomeScreen

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/27/23
 * TIME        : 11:15 PM
 */

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    state: MainViewModelState,
    countryUpdated: (MainViewModelState.Countries) -> Unit,

) {

    NavHost(
        navController = navController,
        startDestination = ScreensNav.Countries.route
    ) {
        composable(route = ScreensNav.Countries.route) {
            HomeScreen(state = state, countryUpdated = countryUpdated)
        }

    }
}