package com.example.quoteOfTheDayApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteOfTheDayApp.ui.theme.QuoteOfTheDayAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteOfTheDay(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun QuoteOfTheDay(modifier: Modifier = Modifier) {

    // List of quotes
    val quoteList = listOf(
        "“We cannot solve problems with the kind of thinking we employed when we came up with them.” —Albert Einstein",
        "“Learn as if you will live forever, live like you will die tomorrow.” —Mahatma Gandhi",
        "“Stay away from those people who try to disparage your ambitions. Small minds will always do that, but great minds will give you a feeling that you can become great too.” —Mark Twain",
        "“When you give joy to other people, you get more joy in return. You should give a good thought to the happiness that you can give out.” —Eleanor Roosevelt",
        "“When you change your thoughts, remember to also change your world.” —Norman Vincent Peale",
        "“It is only when we take chances that our lives improve. The initial and the most difficult risk we need to take is to become honest.” —Walter Anderson",
        "“Nature has given us all the pieces required to achieve exceptional wellness and health, but has left it to us to put these pieces together.” —Diane McLaren"
    )
    var quote by remember { mutableStateOf(quoteList[0]) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = quote,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            // Randomly select a quote from the list when the button is clicked
            Button(onClick = { quote = quoteList[Random.nextInt(quoteList.size)] },
                modifier = Modifier.offset(x = 150.dp,y = 200.dp)) {
                Text("New Quote")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfTheDayAppTheme {

    }
}