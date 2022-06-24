package com.segared.krea.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.segared.krea.R
import com.segared.krea.components.ButtonFilled
import com.segared.krea.components.ButtonTransparent
import com.segared.krea.components.ImageBackground
import com.segared.krea.components.KreaLogo
import com.segared.krea.navigation.KreaScreens

@Composable
fun MainScreen(navController: NavController) {
    Box {
        ImageBackground(imageId = R.drawable.tower_day_2)
        Column( //Main column
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box( //Box with the welcome
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.welcome),
                    fontSize = 38.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(//Box with the krea logo
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                KreaLogo(modifier = Modifier.height(170.dp))
            }
            Column( //Column with de buttons "Log In" and "Sing Up"
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                ButtonFilled(
                    text = stringResource(R.string.log_in),
                    loading = false,
                    validInputs = true,
                    startWeight = 1f,
                    buttonWeight = 3f,
                    endWeight = 1f
                ) {
                    navController.navigate(KreaScreens.Login.route)
                    //Todo Add logic to login
                }
                ButtonTransparent(
                    text = stringResource(R.string.sign_up),
                    startWeight = 1f,
                    buttonWeight = 3f,
                    endWeight = 1f
                ) {
                    navController.navigate(KreaScreens.Signup.route)
                    //Todo Add logic to Signup
                }
            }
        }
    }
}