package com.yourname.mantracounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yourname.mantracounter.navigation.AppNavigation
import com.yourname.mantracounter.ui.theme.MantraCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MantraCounterTheme {
        AppNavigation()
    }
}