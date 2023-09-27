package com.example.globalsphere.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Sept, 9/20/23
 * TIME        : 5:21 AM
 */

@Composable
fun CountryDetails(
    countryDetail: GlobalSphereDetailsState.CountryDetails,
    modifier: Modifier = Modifier
){
    Column() {

        Text(
            text = countryDetail.coatOfArms,
            modifier = Modifier.padding(16.dp),
            fontSize = 22.sp,
            color = Color.Black
        )
        Text(
            text = countryDetail.flag,
            modifier = Modifier.padding(16.dp),
            fontSize = 22.sp,
            color = Color.Black
        )
        Text(
            text = countryDetail.name,
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = countryDetail.capital,
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = countryDetail.population.toString(),
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = countryDetail.region,
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = countryDetail.startOfWeek,
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = countryDetail.timezones.joinToString(postfix = " ") { it },
            modifier = Modifier,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}