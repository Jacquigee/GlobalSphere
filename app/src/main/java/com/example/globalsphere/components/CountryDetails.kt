package com.example.globalsphere.components

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
import com.example.globalsphere.ui.presentation.screens.GlobalSphereDetailsState

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
    Column(modifier = modifier) {

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountryDetailsPreview() {
    val countryDetail = GlobalSphereDetailsState.CountryDetails(
        name = " ",
        capital = " ",
        flag = " ",
        population = 0,
        region = " ",
        startOfWeek = "",
        coatOfArms = " ",
        timezones = listOf()
    )
    Column(modifier = Modifier.fillMaxSize()) {
        CountryDetails(
            countryDetail = GlobalSphereDetailsState.CountryDetails(
                name = "Kenya",
                capital = "Nairobi",
                flag = "",
                population = 0,
                region = "East Africa",
                startOfWeek = "Sunday",
                coatOfArms = "",
                timezones = listOf()
            )
        )
    }
}