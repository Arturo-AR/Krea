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

    object Dashboard : KreaScreens(
        route = "dashboard"
    )

    object Signup : KreaScreens(
        route = "signup"
    )
}
