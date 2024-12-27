package com.example.handphone

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.handphone.navigation.NavigationItem
import com.example.handphone.navigation.Screen
import com.example.handphone.ui.screen.detail.DetailScreen
import com.example.handphone.ui.screen.home.HomeScreen
import com.example.handphone.ui.theme.HandphoneTheme

// Composable utama untuk aplikasi Handphone
@Composable
fun HandphoneApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailHandphone.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Composable untuk screen Home
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { handphoneId -> // Lambda untuk navigasi ke detail
                        navController.navigate(Screen.DetailHandphone.createRoute(handphoneId)) // Navigasi ke detail dengan id
                    }
                )
            }
            // Composable untuk screen DetailHandphone
            composable(
                route = Screen.DetailHandphone.route, // Route untuk screen detail
                arguments = listOf(navArgument("handphoneId") { type = NavType.LongType }), // Argument untuk id handphone
            ) {
                val id = it.arguments?.getLong("handphoneId") ?: -1L // Mendapatkan id handphone dari argument
                DetailScreen(
                    handphoneId = id, // Meneruskan id handphone ke DetailScreen
                    navigateBack = { // Lambda untuk navigasi kembali
                        navController.navigateUp() // Navigasi kembali ke screen sebelumnya
                    },
                )
            }
        }
    }
}

// Composable untuk Bottom Navigation Bar
@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route // Mendapatkan route saat ini

        // List item untuk Bottom Navigation Bar
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home, // Icon untuk item home
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle, // Icon untuk item profile
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

// Preview untuk HandphoneApp
@Preview(showBackground = true)
@Composable
fun HandphoneAppPreview() {
    HandphoneTheme {
        HandphoneApp()
    }
}
// Inti program ini untuk mengatur navigasi aplikasi, termasuk bottom navigation bar, navigasi antar screen,
// dan penggunaan Scaffold untuk layout dasar.