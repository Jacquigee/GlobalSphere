package com.example.globalsphere.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.ui.screens.GlobalSphereState

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Dec, 12/17/23
 * TIME        : 10:12 PM
 */

@Composable
fun CountryDetails(
    country: GlobalSphereState.Countries,
    modifier: Modifier = Modifier,
) {

        Column(
            modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = Color.LightGray)
            ) {
            Text(
                text = country.flag,
                modifier = Modifier.padding(16.dp),
                fontSize = 22.sp,
                color = Color.Black
            )
            Text(
                text = country.name,
                modifier = Modifier,
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = country.capital,
                modifier = Modifier,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountryDetailsPreview(){
    val country = GlobalSphereState.Countries(
        name = "Kenya", capital = "Nairobi", flag = ""
    )
    Column(modifier = Modifier.fillMaxSize()) {
        CountryDetails(country = GlobalSphereState.Countries(name = "Kenya", capital = "Nairobi", flag = "\uD83C\uDDF0\uD83C\uDDEA"))
    }
}
