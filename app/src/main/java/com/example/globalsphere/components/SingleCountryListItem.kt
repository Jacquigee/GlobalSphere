package com.example.globalsphere.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.ui.screens.GlobalSphereState

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/22/23
 * TIME        : 10:05 PM
 */

@Composable
fun SingleCountryListItem(
    country: GlobalSphereState.Countries,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.Cyan, shape = MaterialTheme.shapes.large)
            .clip(MaterialTheme.shapes.large)
    ) {
        Text(
            text = country.name,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontSize = 22.sp
        )
        Text(
            text = country.capital,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontSize = 22.sp
        )
        Text(
            text = country.flag,
            modifier = Modifier.padding(16.dp),
            color = Color.White,
            fontSize = 22.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleCountryListPreview(){
    val country = GlobalSphereState.Countries(
        name = "Kenya", capital = "Nairobi", flag = ""
    )
    Column() {
        SingleCountryListItem(country = country)
    }
}