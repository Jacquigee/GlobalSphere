package com.example.globalsphere.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.globalsphere.R

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/9/23
 * TIME        : 10:39 PM
 */

@Composable
fun GlobalSphere(modifier: Modifier = Modifier) {


    //initial code
//    val flag = painterResource(id = R.drawable.baseline_flag_24)
//    Column(modifier = Modifier) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Column{
////                    Text(text = name, fontSize = 30.sp)
////                    Text(text = capital, fontSize = 26.sp)
//                }
//
////                Image(painter = flag, contentDescription = "Flag", modifier = Modifier.size(70.dp))
//            }
//
//        }
//    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Global Sphere")
@Composable
fun GlobalSpherePreview() {
    GlobalSphere()
}