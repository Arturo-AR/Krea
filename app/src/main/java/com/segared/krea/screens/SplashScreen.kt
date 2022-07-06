package com.segared.krea.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.segared.krea.KreaApplication.Companion.prefs
import com.segared.krea.components.KreaLogo
import com.segared.krea.navigation.KreaScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                })
        )
        delay(1500L) //On screen total time
        if (prefs.getId() == -1) {
            navController.navigate(KreaScreens.Main.route)
        } else {
            navController.navigate(KreaScreens.Dashboard.route)
        }
    }
    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(270.dp)
            .scale(scale.value)
    ) {
        val modifier = Modifier.padding(bottom = 35.dp, top = 10.dp)
        KreaLogo(modifier)
    }
}