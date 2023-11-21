package com.example.globalsphere.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.globalsphere.R

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

        TextField(
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            Placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint),
                    color = Color.Gray,
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Normal
                )
            },
            value = textValue ?: "",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardAction?.invoke()
                    keyboard?.hide()
                }
            ),
            singleLine = true,
            onValueChange = {
                textValueChange?.invoke(it)
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.image_search),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 21.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        )
    }

}
