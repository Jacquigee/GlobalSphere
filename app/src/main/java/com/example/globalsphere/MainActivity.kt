package com.example.globalsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.globalsphere.ui.theme.GlobalSphereTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalSphereTheme {
                Surface(tonalElevation = 5.dp) {
                    GlobalSphere()
                }
            }
        }
    }
}

@Composable
fun GlobalSphere() {

}
