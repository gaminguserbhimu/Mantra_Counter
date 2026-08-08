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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember

@Composable
fun HomeScreen(navController: NavController,
               viewModel: MantraViewModel
) {

    val mantras = viewModel.mantras.collectAsState()
    var showDeleteDialog by remember { mutableStateOf(false) }

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

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                showDeleteDialog = true
                            }
                        ) {
                            Text("Delete")
                        }

                        if (showDeleteDialog) {

                            AlertDialog(
                                onDismissRequest = {
                                    showDeleteDialog = false
                                },

                                title = {
                                    Text("Delete Mantra?")
                                },

                                text = {
                                    Text(
                                        "Are you sure you want to delete \"${mantra.name}\"?"
                                    )
                                },

                                confirmButton = {

                                    TextButton(
                                        onClick = {
                                            viewModel.deleteMantra(mantra)
                                            showDeleteDialog = false
                                        }
                                    ) {
                                        Text("Delete")
                                    }
                                },

                                dismissButton = {

                                    TextButton(
                                        onClick = {
                                            showDeleteDialog = false
                                        }
                                    ) {
                                        Text("Cancel")
                                    }
                                }
                            )
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