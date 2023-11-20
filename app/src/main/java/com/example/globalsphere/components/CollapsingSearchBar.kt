package com.example.globalsphere.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.R
import com.example.globalsphere.ui.theme.GlobalSphereTheme

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Nov, 11/20/23
 * TIME        : 7:59 PM
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CollapsingSearchBar(
    modifier: Modifier = Modifier,
    toolbarOffset: Float = 0f,
    toolbarHeight: Dp = 100.dp,
    minShrinkHeight: Dp = 0.dp,
    textValue: String? = null,
    keyboardAction: (() -> Unit)? = null,
    textValueChange: ((String) -> Unit)? = null
) {
    val keyboard = LocalSoftwareKeyboardController.current

    CollapsingToolbarBase(
        modifier = modifier.wrapContentSize(),
        toolbarOffset = toolbarOffset,
        toolbarHeight = toolbarHeight,
        minShrinkHeight = minShrinkHeight
    ) {
        Column(
            modifier = Modifier.wrapContentHeight()
        ) {
            Text(
                text = stringResource(id = R.string.search_country),
                color = Color.White,
                fontSize = 13.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(top = 25.dp)
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                CountrySearchBox(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(weight = 3f)
                        .padding(end = 10.dp),
                    textValue = textValue,
                    keyboard = keyboard,
                    keyboardAction = keyboardAction
                ) {
                    textValueChange?.invoke(it)
                }

                SearchButton(
                    modifier = Modifier
                        .size(55.dp)
                        .weight(weight = 0.6f)
                ) {
                    keyboard?.hide()
                    keyboardAction?.invoke()
                }
            }
        }
    }
}

@Composable
private fun PreviewCollapsingSearchBar() {
    GlobalSphereTheme {
        CollapsingSearchBar()
    }
}