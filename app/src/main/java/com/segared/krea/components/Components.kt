package com.segared.krea.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.segared.krea.R
import com.segared.krea.ui.theme.TransparentGray

/**
 * Button with default red background and white text
 */
@Composable
fun ButtonFilled(
    modifier: Modifier = Modifier,
    text: String,
    background: Color = Color.Red,
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
        Button(
            modifier = modifier
                .weight(buttonWeight)
                .fillMaxWidth(),
            onClick = { onClick.invoke() },
            colors = ButtonDefaults.buttonColors(
                contentColor = textColor,
                backgroundColor = background
            )
        ) {
            Text(modifier = Modifier.padding(4.dp), text = text)
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
            Text(modifier = Modifier.padding(4.dp), text = text)
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

@Preview
@Composable
fun TextInputs(
    modifier: Modifier = Modifier,
    label: String = "Numero de casa",
    textAlignment: TextAlign = TextAlign.Start
) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            label = { Text(text = label) },
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TransparentGray,
                textColor = Color.White,
                focusedIndicatorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedIndicatorColor = Color.White,
                unfocusedLabelColor = Color.White
            )
        )
    }
}