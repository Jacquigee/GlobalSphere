package com.example.globalsphere.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.ui.screens.MainViewModelState

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/22/23
 * TIME        : 10:05 PM
 */

@Composable
fun SingleCountryListItem(
    country: MainViewModelState.Countries,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color.LightGray, shape = MaterialTheme.shapes.large)
            .clip(MaterialTheme.shapes.large)
            .clickable { onClick() }
    ) {
        Text(
            text = country.flag,
            modifier = Modifier.padding(16.dp),
            fontSize = 22.sp,
            color = Color.Black
        )
        Column() {
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
}
