package com.example.globalsphere

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.globalsphere.ui.theme.GlobalSphereTheme
import com.example.globalsphere.view.GlobalSphere

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
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun GlobalSpherePreview(){
    GlobalSphereTheme {
        GlobalSphere()
    }
}