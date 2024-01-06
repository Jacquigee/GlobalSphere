package com.example.globalsphere.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.globalsphere.R
import com.example.globalsphere.ui.screens.MainViewModelState


/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/9/23
 * TIME        : 10:39 PM
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalSphere(
    state: MainViewModelState,
    countryUpdated: (MainViewModelState.Countries) -> Unit
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { GlobalSphereTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
        ) {
//            HomeScreen(globalSphereState = )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalSphereTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}
@Preview(showBackground = true, showSystemUi = true, name = "Global Sphere")
@Composable
fun GlobalSpherePreview() {
    GlobalSphere(MainViewModelState.Loading){}
}