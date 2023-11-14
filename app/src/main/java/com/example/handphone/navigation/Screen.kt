package com.example.handphone.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailHandphone : Screen("home/{handphoneId}") {
        fun createRoute(handphoneId: Long) = "home/$handphoneId"
    }
}