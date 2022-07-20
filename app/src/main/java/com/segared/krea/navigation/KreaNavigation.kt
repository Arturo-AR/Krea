package com.segared.krea.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.segared.krea.screens.SplashScreen
import com.segared.krea.screens.accescontrol.AccessControlScreen
import com.segared.krea.screens.accountrequest.AccountRequestScreen
import com.segared.krea.screens.dashboard.DashboardScreen
import com.segared.krea.screens.login.LoginScreen
import com.segared.krea.screens.login.LoginScreenViewModel
import com.segared.krea.screens.main.MainScreen
import com.segared.krea.screens.signup.SingUpScreen

@ExperimentalComposeUiApi
@Composable
fun KreaNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = KreaScreens.Splash.route) {
        composable(KreaScreens.Main.route) {
            MainScreen(navController = navController)
        }
        composable(KreaScreens.AccountsRequest.route){
            AccountRequestScreen(navController = navController)
        }
        composable(KreaScreens.Login.route) {
            val viewModel = hiltViewModel<LoginScreenViewModel>()
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable(KreaScreens.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(KreaScreens.Signup.route) {
            SingUpScreen(navController = navController)
        }
        composable(KreaScreens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(KreaScreens.AccessControl.route) {
            AccessControlScreen(navController = navController)
        }
    }
}