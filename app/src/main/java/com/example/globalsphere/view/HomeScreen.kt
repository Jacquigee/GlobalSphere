package com.example.globalsphere.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.globalsphere.data.CountryInfo

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 11:15 PM
 */
@Composable
fun HomeScreen(
    globalSphereState: List<CountryInfo>, modifier: Modifier = Modifier
) {
ResultScreen(globalSphereState, modifier)
}

@Composable
fun ResultScreen(countries: List<CountryInfo>, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
      Text(text = countries.toString())
    }

}