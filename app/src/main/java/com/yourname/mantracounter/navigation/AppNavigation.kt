package com.yourname.mantracounter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.yourname.mantracounter.*
import com.yourname.mantracounter.model.HomeScreen
import com.yourname.mantracounter.ui.screen.AddMantraScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("add") {
            AddMantraScreen(navController)
        }

    }

}