package com.segared.krea.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilledButton(
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
        Text(text = text)
    }
}

@Composable
fun TransparentButton(
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
        Text(text = text)
    }
}