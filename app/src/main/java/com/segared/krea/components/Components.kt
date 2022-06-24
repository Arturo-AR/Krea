package com.segared.krea.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.segared.krea.R

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId: String = "Número de casa",
    enable: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    InputField(
        modifier = modifier,
        valueState = emailState,
        labelId = labelId,
        enable = enable,
        keyboardType = KeyboardType.Number,
        imeAction = imeAction,
        onAction = onAction
    )
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enable: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    TextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enable,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )
}

@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    labelId: String,
    enable: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    val visualTransformation = if (passwordVisibility.value) VisualTransformation.None else
        PasswordVisualTransformation()

    TextField(
        value = passwordState.value,
        onValueChange = {
            passwordState.value = it
        },
        label = { Text(text = labelId) },
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enable,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            Icon(
                imageVector = if (passwordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = null
            )
            PasswordVisibility(passwordVisibility = passwordVisibility)
        },
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val visible = passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value = !visible }) {
        Icons.Default.Close
    }
}

/**
 * Button with default red background and white text
 */
@Composable
fun ButtonFilled(
    modifier: Modifier = Modifier,
    text: String,
    background: Color = Color.Red,
    textColor: Color = Color.White,
    loading: Boolean,
    validInputs: Boolean,
    //Percent start, button and end, to custom the size
    startWeight: Float,
    buttonWeight: Float,
    endWeight: Float,
    onClick: () -> Unit
) {
    Row {
        Box(
            modifier = Modifier
                .weight(startWeight)
                .fillMaxWidth()
        )
        Button(
            modifier = modifier
                .weight(buttonWeight)
                .fillMaxWidth(),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                contentColor = textColor,
                backgroundColor = background
            ),
            enabled = !loading && validInputs,
        ) {
            Text(modifier = Modifier.padding(4.dp), text = text, maxLines = 1)
        }
        Box(
            modifier = Modifier
                .weight(endWeight)
                .fillMaxWidth()
        )
    }
}

/**
 * OutlinedButton with default transparent background and white text
 */
@Composable
fun ButtonTransparent(
    modifier: Modifier = Modifier,
    text: String,
    background: Color = Color.Transparent,
    textColor: Color = Color.White,
    //Percent start, button and end, to custom the size
    startWeight: Float,
    buttonWeight: Float,
    endWeight: Float,
    onClick: () -> Unit
) {
    Row {
        Box(
            modifier = Modifier
                .weight(startWeight)
                .fillMaxWidth()
        )
        OutlinedButton(
            modifier = modifier
                .weight(buttonWeight)
                .fillMaxWidth(),
            onClick = { onClick.invoke() },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = textColor,
                backgroundColor = background
            )
        ) {
            Text(modifier = Modifier.padding(4.dp), text = text, maxLines = 1)
        }
        Box(
            modifier = Modifier
                .weight(endWeight)
                .fillMaxWidth()
        )
    }
}

/**
 * Composable to paint the krea logo
 */
@Composable
fun KreaLogo(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.logo_krea),
        contentDescription = stringResource(R.string.krea_logo)
    )
}

/**
 * Composable to paint a fullscreen image background
 */
@Composable
fun ImageBackground(
    imageId: Int
) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}