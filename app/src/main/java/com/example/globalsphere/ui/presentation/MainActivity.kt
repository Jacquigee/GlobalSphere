package com.example.globalsphere.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.globalsphere.ui.designsystem.theme.GlobalSphereTheme
import com.example.globalsphere.ui.presentation.screens.MainViewModel
import com.example.globalsphere.ui.presentation.screens.MainViewModelState
import com.example.globalsphere.ui.presentation.view.GlobalSphere
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalSphereTheme {
                Surface(tonalElevation = 5.dp) {

                }
            }
        }
    }
}