package com.example.handphone.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)

//Merepresentasikan item navigasi dengan judul, ikon, dan layar tujuan.