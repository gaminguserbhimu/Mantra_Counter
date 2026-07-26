package com.yourname.mantracounter.model

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    val mantras = listOf(
        Mantra(1,"Om Namah Shivaya",54),

        Mantra(2,"Gayatri Mantra",108),

        Mantra(3,"Maha Mrityunjaya",21),

        Mantra(4,"Hanuman Chalisa",1)

    )

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

            items(mantras) { mantra ->

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
                            onClick = { }
                        ) {
                            Text("Start")
                        }
                    }
                }
            }
        }
    }
}