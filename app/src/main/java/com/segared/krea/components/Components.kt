package com.segared.krea.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.segared.krea.R
/**
 * Button with default red background and white text
 */
@Composable
fun ButtonFilled(
    modifier: Modifier = Modifier,
    text: String,
    background: Color = Color.Red,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 80.dp),
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            backgroundColor = background
        )
    ) {
        Text(modifier = Modifier.padding(4.dp), text = text)
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
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 80.dp),
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = textColor,
            backgroundColor = background
        )
    ) {
        Text(modifier = Modifier.padding(4.dp), text = text)
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