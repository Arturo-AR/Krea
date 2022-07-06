package com.segared.krea.navigation

sealed class KreaScreens(
    val route: String
) {

    object AccessControl : KreaScreens(
        route = "accessControl"
    )

    object Splash : KreaScreens(
        route = "splash"
    )

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
