package com.yourname.mantracounter.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.yourname.mantracounter.viewmodel.MantraViewModel

@Composable
fun AddMantraScreen(
    navController: NavController,
    viewModel: MantraViewModel
) {

    Text("Add Mantra")

}