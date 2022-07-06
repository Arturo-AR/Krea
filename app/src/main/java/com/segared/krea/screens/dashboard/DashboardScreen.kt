package com.segared.krea.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.segared.krea.R
import com.segared.krea.components.ImageBackground
import com.segared.krea.components.ShowAlertDialog
import com.segared.krea.navigation.KreaScreens

@Composable
fun DashboardScreen(navController: NavController) {
    val openDialog = remember {
        mutableStateOf(false)
    }
    if (openDialog.value) {
        ShowAlertDialog(
            title = "Alerta !!",
            message = "Estas seguro de cerrar sesion ?",
            openDialog = openDialog
        ) {
            navController.navigate(KreaScreens.Main.route)
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        ImageBackground(imageId = R.drawable.tower_day_2)
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = {
                    openDialog.value = !openDialog.value
                }) {
                    Icon(Icons.Default.Logout, null)
                }
            }
            Column {

            }
        }
    }
}