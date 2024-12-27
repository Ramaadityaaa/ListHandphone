package com.example.handphone.navigation
sealed class Screen(val route: String) {
    // Object untuk layar Home.
    object Home : Screen("home")

    //Object untuk layar Profile.
    object Profile : Screen("profile")

    // Object untuk layar desakripsi Handphone.
    object DetailHandphone : Screen("home/{handphoneId}") {
        fun createRoute(handphoneId: Long) = "home/$handphoneId"
    }
}

// Inti dari program ini yaitu untuk mendefinisikan layar-layar dalam aplikasi dengan rute navigasi masing-masing,
// memungkinkan navigasi yang terstruktur dan aman.