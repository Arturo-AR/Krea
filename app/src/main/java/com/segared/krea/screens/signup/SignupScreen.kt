package com.segared.krea.screens.signup

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun SingUpScreen(navController: NavController) {
    Text(text = "Crear usuario", fontWeight = FontWeight.Bold)
}