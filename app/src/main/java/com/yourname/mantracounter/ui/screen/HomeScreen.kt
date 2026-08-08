package com.yourname.mantracounter.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yourname.mantracounter.viewmodel.MantraViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun HomeScreen(navController: NavController,
               viewModel: MantraViewModel
) {

    val mantras = viewModel.mantras.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "🙏 Japa",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "My Mantras",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(mantras.value) { mantra ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = mantra.name,
                            fontSize = 20.sp
                        )

                        Text(
                            text = "Goal : ${mantra.goal}"
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                navController.navigate("chant/${mantra.id}")
                            }
                        ) {
                            Text("Start")
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate("add")
            }
        ) {
            Text("ADD +")
        }
    }
}