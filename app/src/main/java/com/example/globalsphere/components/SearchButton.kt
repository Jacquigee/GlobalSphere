package com.example.globalsphere.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.globalsphere.R

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Nov, 11/21/23
 * TIME        : 9:13 PM
 */
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SearchButton(
    modifier: Modifier = Modifier,
    onSearchButtonClicked: (() -> Unit)? = null
) {
    IconButton(
        onClick = { onSearchButtonClicked?.invoke() },
        modifier = modifier
            .background(shape = RoundedCornerShape(10.dp), color = Color.Gray)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {
        Image(
            modifier = Modifier.wrapContentSize(),
            painter = painterResource(id = R.drawable.search_24),
            contentScale = ContentScale.Inside,
            contentDescription = null
        )
    }
}