package com.example.globalsphere.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.R
import com.example.globalsphere.components.SingleCountryListItem
import com.example.globalsphere.ui.screens.MainViewModelState

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/14/23
 * TIME        : 11:15 PM
 */
@Composable
fun HomeScreen(
    state:MainViewModelState, modifier: Modifier = Modifier, countryUpdated: (MainViewModelState.Countries) -> Unit
) {
    when (state) {

        MainViewModelState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
        MainViewModelState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is MainViewModelState.Success -> ResultScreen(state.countries, modifier = modifier.fillMaxWidth(), countryUpdated)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ResultScreen(countries: List<MainViewModelState.Countries>, modifier: Modifier = Modifier, onCountryUpdated: (MainViewModelState.Countries) -> Unit) {
    LazyColumn( verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        stickyHeader {
            Text(
                text = "Global Sphere",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            )
        }
        items(countries){
            SingleCountryListItem(country = it){
                onCountryUpdated(it)
            }
        }
    }

}