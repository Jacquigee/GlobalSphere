package com.example.globalsphere.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.unit.dp

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Nov, 11/21/23
 * TIME        : 5:34 AM
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CountrySearchBox(
    modifier: Modifier = Modifier,
    textValue: String? = null,
    keyboard: SoftwareKeyboardController? = null,
    keyboardAction: (() -> Unit)? = null,
    textValueChange: ((String) -> Unit)? = null
) {
    Row(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.White
            )
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .wrapContentHeight()
    ) {

    }

}
