package com.segared.krea.screens.dashboard

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Text(text = "Menu principal", fontWeight = FontWeight.Bold)
}