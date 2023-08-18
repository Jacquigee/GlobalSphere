package com.example.globalsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.globalsphere.ui.theme.GlobalSphereTheme
import com.example.globalsphere.view.GlobalSphere

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalSphereTheme {
                GlobalSphere()
            }
        }
    }
}