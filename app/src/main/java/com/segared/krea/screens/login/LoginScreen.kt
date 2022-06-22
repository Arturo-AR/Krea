package com.segared.krea.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.segared.krea.components.TextInputs

@Composable
fun LoginScreen() {
    Box {
        //ImageBackground(imageId = R.drawable.tower_day_2)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                TextInputs(
                    label = "Numero de casa",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    textAlignment = TextAlign.Center
                )
                TextInputs(
                    label = "Contraseña",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    textAlignment = TextAlign.Center
                )
            }
            Column(modifier = Modifier.weight(1f)) {

            }
        }
    }
}