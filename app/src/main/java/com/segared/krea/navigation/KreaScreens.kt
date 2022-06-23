package com.segared.krea.navigation

sealed class KreaScreens(
    val route: String
) {
    object Main : KreaScreens(
        route = "main"
    )

    object Login : KreaScreens(
        route = "login"
    )
}
