package com.example.globalsphere.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.globalsphere.R
import com.example.globalsphere.components.SingleCountryListItem
import com.example.globalsphere.ui.screens.GlobalSphereDetailsState
import com.example.globalsphere.ui.screens.GlobalSphereState

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 11:15 PM
 */
@Composable
fun HomeScreen(
    globalSphereState: GlobalSphereState, modifier: Modifier = Modifier
) {
    when (globalSphereState) {
        is GlobalSphereState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is GlobalSphereState.Success ->
            ResultScreen(globalSphereState.countries, modifier = modifier.fillMaxWidth())

        is GlobalSphereState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        contentScale = ContentScale.None,
        modifier = modifier.size(1.dp),
        painter = painterResource(R.drawable.progress_activity_48px),
        contentDescription = stringResource(
            id = R.string.loading
        )
    )
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = Icons.Default.Warning, contentDescription = " ")
        Text(text = stringResource(R.string.error), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ResultScreen(countries: List<GlobalSphereState.Countries>, modifier: Modifier = Modifier) {
//    Box(contentAlignment = Alignment.Center, modifier = modifier) {
//        Text(text = countries.toString())
//    }
    LazyColumn( verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        items(countries){
            SingleCountryListItem(country = it)
        }
    }

}