package com.example.greetingsApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingsApp.ui.theme.GreetingsAppTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingApp(modifier = Modifier.padding(innerPadding)
                        .fillMaxSize()
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingApp(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, MaterialTheme.colorScheme.onSurface)
                ) {
                    if (name.isEmpty()) {
                        Text(
                            text = "Enter your name",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    innerTextField()
                }
            }
        )

        // Greeting message based on time of day
        Button(
            onClick = {
                val currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
                val timeOfDay = when (currentTime){
                    in 0..11 -> "morning"
                    in 12..16 -> "afternoon"
                    in 17..20 -> "evening"
                    else -> "night"
                }
                msg = "Hello $name, hope you have a wonderful $timeOfDay!"
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Confirm")
        }
        if (msg.isNotEmpty()) {
            Text(
                text = msg,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingsAppTheme {
        GreetingApp()
    }
}