package com.example.globalsphere.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 11:15 PM
 */
@Composable
fun HomeScreen(
    globalSphereState: String, modifier: Modifier = Modifier
) {
ResultScreen(globalSphereState, modifier)
}

@Composable
fun ResultScreen(countries : String, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Text(text = " ")
    }

}