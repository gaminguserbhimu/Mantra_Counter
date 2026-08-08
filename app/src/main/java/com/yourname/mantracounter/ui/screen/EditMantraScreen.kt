package com.yourname.mantracounter.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yourname.mantracounter.model.Mantra
import com.yourname.mantracounter.viewmodel.MantraViewModel

@Composable
fun EditMantraScreen(
    navController: NavController,
    viewModel: MantraViewModel,
    mantraId: Int
) {

    val mantra = viewModel.getMantraById(mantraId)

    if (mantra == null) {
        Text("Mantra not found")
        return
    }

    var mantraName by remember {
        mutableStateOf(mantra.name)
    }

    var goal by remember {
        mutableStateOf(mantra.goal.toString())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Edit Mantra",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = mantraName,
            onValueChange = {
                mantraName = it
            },
            label = {
                Text("Mantra Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = goal,
            onValueChange = {
                goal = it
            },
            label = {
                Text("Goal")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                val goalValue = goal.toIntOrNull() ?: 0

                if (mantraName.isNotBlank() && goalValue > 0) {

                    viewModel.updateMantra(
                        Mantra(
                            id = mantra.id,
                            name = mantraName,
                            goal = goalValue
                        )
                    )

                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Changes")
        }
    }
}