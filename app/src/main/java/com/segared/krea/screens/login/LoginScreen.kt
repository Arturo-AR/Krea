package com.segared.krea.screens.login

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.segared.krea.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.segared.krea.components.ButtonFilled
import com.segared.krea.components.ButtonTransparent
import com.segared.krea.components.ImageBackground
import com.segared.krea.components.TextInputs
import com.segared.krea.navigation.KreaScreens
import com.segared.krea.ui.theme.TransparentGray

@Composable
fun LoginScreen(navController: NavController) {
    Box {
        ImageBackground(imageId = R.drawable.tower_day_2)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                TextInputs(
                    label = "Numero de casa",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextInputs(
                    label = "Contraseña",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                ButtonFilled(
                    text = "Iniciar Sesión",
                    startWeight = 1f,
                    buttonWeight = 1.5f,
                    endWeight = 1f
                ) {
                    Log.d("Iniciar", "Iniciar sesion")
                }
                ButtonTransparent(
                    text = "Cancelar",
                    startWeight = 1f,
                    buttonWeight = 1.5f,
                    endWeight = 1f,
                    background = TransparentGray
                ) {
                    navController.navigate(KreaScreens.Main.route)
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}