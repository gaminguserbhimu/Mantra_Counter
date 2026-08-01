package com.yourname.mantracounter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.yourname.mantracounter.model.HomeScreen
import com.yourname.mantracounter.ui.screen.AddMantraScreen
import com.yourname.mantracounter.viewmodel.MantraViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val viewModel = androidx.lifecycle.viewmodel.compose.viewModel<MantraViewModel>()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("add") {
            AddMantraScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }

    }

}