package com.yourname.mantracounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourname.mantracounter.ui.theme.MantraCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MantraCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MantraCounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MantraCounterScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🙏 Mantra Counter",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Om Namah Shivya",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "0 / 54",
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { }) {
            Text("Start Listening")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }) {
            Text("Stop")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MantraCounterTheme {
        MantraCounterScreen()
    }
}