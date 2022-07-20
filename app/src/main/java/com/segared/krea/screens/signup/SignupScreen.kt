package com.segared.krea.screens.signup

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.krea.R
import com.segared.krea.components.*
import com.segared.krea.navigation.KreaScreens
import com.segared.krea.screens.login.LoginScreenViewModel
import com.segared.krea.ui.theme.TransparentGray

@ExperimentalComposeUiApi
@Composable
fun SingUpScreen(
    navController: NavController,
    viewModel: SignupScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val name = rememberSaveable { mutableStateOf("") }
    val lastName = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val phone = rememberSaveable { mutableStateOf("") }
    val street = rememberSaveable { mutableStateOf("") }
    val outdoorNumber = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(name.value, lastName.value, email.value, password.value) {
        name.value.trim().isNotEmpty() && lastName.value.trim().isNotEmpty() && email.value.trim()
            .isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val loading = false
    Box {
        ImageBackground(imageId = R.drawable.tower_day_2)
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {

            }
            Column(
                modifier = Modifier
                    .weight(5f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                InputField(
                    labelId = "Correo",
                    valueState = email,
                    enable = !loading,
                    keyboardType = KeyboardType.Email
                )
                PasswordInput(
                    modifier = Modifier,
                    passwordState = password,
                    labelId = stringResource(id = R.string.password),
                    enable = !loading,
                    imeAction = ImeAction.Next,
                    passwordVisibility = passwordVisibility
                )
                InputField(
                    labelId = "Nombre",
                    valueState = name,
                    enable = !loading
                )
                InputField(
                    labelId = "Apellido",
                    valueState = lastName,
                    enable = !loading
                )
                Row {
                    InputField(
                        modifier = Modifier.weight(1f),
                        labelId = "Celular",
                        keyboardType = KeyboardType.Phone,
                        valueState = phone,
                        enable = !loading
                    )
                    InputField(
                        modifier = Modifier.weight(1f),
                        labelId = "Numero Exterior",
                        keyboardType = KeyboardType.Text,
                        valueState = outdoorNumber,
                        enable = !loading
                    )
                }
                InputField(
                    labelId = "Calle",
                    valueState = street,
                    enable = !loading,
                    imeAction = ImeAction.Done,
                    onAction = KeyboardActions {
                        if (!valid) return@KeyboardActions
                        keyboardController?.hide()
                    }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1.6f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonFilled(
                    text = "Registrar",
                    loading = false,
                    validInputs = valid,
                    startWeight = 1f,
                    buttonWeight = 1f,
                    endWeight = 1f
                ) {
                    val info = viewModel.createInfo(
                        name.value,
                        lastName.value,
                        phone.value,
                        street.value,
                        outdoorNumber.value,
                        email.value,
                        password.value
                    )
                    viewModel.signUp(
                        info,
                        onError = {
                            Toast.makeText(context, "Error al registar", Toast.LENGTH_SHORT).show()
                        },
                        onSuccess = {
                            Toast.makeText(context, "Su solicitud esta siendo procesada", Toast.LENGTH_LONG).show()
                            navController.navigate(KreaScreens.Main.route)
                        })

                }
                ButtonTransparent(
                    background = TransparentGray,
                    text = "Cancelar",
                    startWeight = 1f,
                    buttonWeight = 1f,
                    endWeight = 1f
                ) {
                    navController.navigate(KreaScreens.Main.route)
                }
            }
        }
    }
}