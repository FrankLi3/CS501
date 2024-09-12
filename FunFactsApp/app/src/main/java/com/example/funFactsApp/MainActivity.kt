package com.example.funFactsApp

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funFactsApp.ui.theme.FunFactsAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFacts(
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
fun FunFacts(modifier: Modifier = Modifier) {

    // List of fun facts, colors, and fonts
    val funFacts = listOf(
        "Australia is wider than the moon.",
        "Venus is the only planet to spin clockwise.",
        "Allodoxaphobia is the fear of other people’s opinions.",
        "Human teeth are the only part of the body that cannot heal themselves.",
        "Competitive art used to be an Olympic sport.",
        "The first person processed at Ellis Island was a 15-year-old girl from Ireland.",
        "Google Images was created after Jennifer Lopez wore the green dress at the 2000 Grammys.",
        "Lemons float, but limes sink.",
        "The Eiffel Tower was originally made for Barcelona.",
        "It would take 19 minutes to fall to the center of the Earth.",
        "The real name for a hashtag is an octothorpe.",
        "Neil Armstrong’s hair was sold in 2004 for $3,000.",
        "The longest English word is 189,819 letters long.",
        "The tiny pocket in jeans was designed to store pocket watches.",
        "People once ate arsenic to improve their skin.",
        "“The Terminator” script was sold for $1.",
        "Penicillin was first called “mold juice.”",
        "A fear of long words is called Hippopotomonstrosesquippedaliophobia.",
        "The quickest commercial flight in the world is in Scotland.",
        "The first commercial passenger flight lasted only 23 minutes."
    )

    val colors = listOf(Color.Black, Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.Cyan)
    val fonts = listOf(
        FontFamily.Default,
        FontFamily.Serif,
        FontFamily.SansSerif,
        FontFamily.Monospace,
        FontFamily.Cursive
    )

    var fact by remember { mutableStateOf(funFacts[0]) }
    var textColor by remember { mutableStateOf(Color.Black) }
    var font by remember { mutableStateOf(FontFamily.Default) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = fact,
                color = textColor,
                fontFamily = font,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(16.dp))

    // Randomly select a new fact, text color, and font when the button is clicked
    Button(
        onClick = {
            fact = funFacts[Random.nextInt(funFacts.size)]
            textColor = colors[Random.nextInt(colors.size)]
            font = fonts[Random.nextInt(fonts.size)]
        },
        modifier = Modifier.offset(x = 150.dp, y = 200.dp)
    ) {
        Text("New Fact")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsAppTheme {
        FunFacts()
    }
}