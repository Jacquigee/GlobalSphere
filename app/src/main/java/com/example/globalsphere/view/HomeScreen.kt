package com.example.globalsphere.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.globalsphere.R
import com.example.globalsphere.data.CountryInfo
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
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.baseline_downloading_24),
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
        Image(
            painter = painterResource(id = R.drawable.baseline_error_24), contentDescription = ""
        )
        Text(text = stringResource(R.string.error), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ResultScreen(countries: String, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Text(text = countries.toString())
    }

//    LazyColumn(modifier = modifier){
//        items(countries){ country ->
//            CountryRow(country)
//        }
//    }

}

@Composable
private fun CountryRow(country: CountryInfo) = Unit