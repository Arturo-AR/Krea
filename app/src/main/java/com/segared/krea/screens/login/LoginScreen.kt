package com.segared.krea.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.segared.krea.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.segared.krea.components.*
import com.segared.krea.navigation.KreaScreens
import com.segared.krea.ui.theme.TransparentGray

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(navController: NavController) {
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val loading = false
    Box {
        ImageBackground(imageId = R.drawable.tower_day_2)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EmailInput(
                    emailState = email,
                    enable = !loading,
                    onAction = KeyboardActions {
                        passwordFocusRequest.requestFocus()
                    })
                PasswordInput(
                    modifier = Modifier.focusRequester(passwordFocusRequest),
                    passwordState = password,
                    labelId = "Contraseña",
                    enable = !loading,
                    passwordVisibility = passwordVisibility,
                    onAction = KeyboardActions {
                        if (!valid) return@KeyboardActions
                        keyboardController?.hide()
                    })
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                ButtonFilled(
                    text = "Iniciar Sesíon",
                    loading = loading,
                    validInputs = valid,
                    startWeight = 1f,
                    buttonWeight = 1.5f,
                    endWeight = 1f
                ) {
                    navController.navigate(KreaScreens.Dashboard.route)
                }
                ButtonTransparent(
                    background = TransparentGray,
                    text = "Cancelar",
                    startWeight = 1f,
                    buttonWeight = 1.5f,
                    endWeight = 1f
                ) {
                    navController.navigate(KreaScreens.Main.route)
                }
            }
        }
    }
}