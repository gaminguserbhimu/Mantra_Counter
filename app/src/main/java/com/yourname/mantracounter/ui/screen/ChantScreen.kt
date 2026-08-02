package com.yourname.mantracounter.ui.screen

import android.widget.Button
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yourname.mantracounter.viewmodel.MantraViewModel

@Composable
fun ChantScreen(
    navController: NavController,
    viewModel: MantraViewModel,
    mantraId: Int
) {

    val mantra = viewModel.getMantraById(mantraId)
    var count by remember { mutableStateOf(0) }

    val progress =
        count.toFloat() / (mantra?.goal?.toFloat() ?: 1f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "🙏 Japa",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = mantra?.name ?: "",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Goal : ${mantra?.goal ?: 0}",
            fontSize = 20.sp
        )

        Text(
            text = "$count / ${mantra?.goal}",
            fontSize = 36.sp
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )

        if (count == (mantra?.goal ?: 0)) {

            Text(
                text = "🎉 Japa Completed",
                fontSize = 24.sp
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable {

                    if (count < (mantra?.goal ?: 0)) {
                        count++
                    }

                },
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "TAP TO COUNT",
                fontSize = 26.sp
            )

        }

        if (count == (mantra?.goal ?: 0)) {

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Finish")
            }

        }
    }
}