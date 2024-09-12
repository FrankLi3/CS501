package com.example.celsiustofahrenheitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.celsiustofahrenheitconverter.ui.theme.CelsiusToFahrenheitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CelsiusToFahrenheitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        CToFConverter()
                    }
                }
            }
        }
    }
}


@Composable
fun CToFConverter() {
    var c by remember { mutableStateOf(0f) }
    var f by remember { mutableStateOf(32f) }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.align(Alignment.Center)
                .border(1.dp, MaterialTheme.colorScheme.onSurface)
                .size(300.dp).padding(16.dp)
        ) {
            Column(modifier = Modifier.align(Alignment.Center).padding(20.dp)) {
                // Celsius to Fahrenheit converter, value range from 0 to 100
                Text(text = "Celsius: ${c.roundToInt()}ºC")
                Slider(
                    value = c,
                    onValueChange = {
                        c = it
                        f = c * 9 / 5 + 32
                    },
                    valueRange = 0f..100f,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Fahrenheit to Celsius converter, value range from 32 to 212
                Text(text = "Fahrenheit: ${f.roundToInt()}ºF")
                Slider(
                    value = f,
                    onValueChange = {
                        f = if (it < 32f) 32f else it
                        c = (f - 32) * 5 / 9
                    },
                    valueRange = 32f..212f,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // print a message based on the temperature value
                val message =
                    if (c <= 20) "I wish it were warmer." else "I wish it were colder."
                Text(text = message, modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CelsiusToFahrenheitConverterTheme {
        CToFConverter()
    }
}
