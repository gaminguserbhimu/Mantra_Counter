package com.yourname.mantracounter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.yourname.mantracounter.ui.screen.AddMantraScreen
import com.yourname.mantracounter.ui.screen.ChantScreen
import com.yourname.mantracounter.ui.screen.EditMantraScreen
import com.yourname.mantracounter.ui.screen.HomeScreen
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

        composable("chant/{mantraId}") { backStackEntry ->

            val mantraId =
                backStackEntry.arguments?.getString("mantraId")?.toInt() ?: 0

            ChantScreen(
                navController = navController,
                viewModel = viewModel,
                mantraId = mantraId
            )
        }

        composable("add") {
            AddMantraScreen(
                navController = navController,
                viewModel = viewModel,
            )
        }

        composable("edit/{mantraId}") { backStackEntry ->

            val mantraId =
                backStackEntry.arguments
                    ?.getString("mantraId")
                    ?.toInt() ?: 0

            EditMantraScreen(
                navController = navController,
                viewModel = viewModel,
                mantraId = mantraId
            )
        }

    }

}