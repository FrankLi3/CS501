package com.example.simplearithmetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplearithmetic.ui.theme.SimpleArithmeticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleArithmeticTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        arithmetic(modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}

@Composable
fun arithmetic(modifier: Modifier = Modifier) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var oper by remember { mutableStateOf("+") }
    var result by remember { mutableStateOf("") }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .size(400.dp)
            .border(1.dp, MaterialTheme.colorScheme.onSurface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = num1,
            onValueChange = { num1 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    if (num1.isEmpty()) {
                        Text("Enter first number")
                    }
                    innerTextField()
                }
            }
        )
        BasicTextField(
            value = num2,
            onValueChange = { num2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    if (num2.isEmpty()) {
                        Text("Enter second number")
                    }
                    innerTextField()
                }
            }
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = oper == "+",
                    onClick = { oper = "+" },
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("+")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = oper == "-",
                    onClick = { oper = "-" },
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("-")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = oper == "*",
                    onClick = { oper = "*" },
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("*")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = oper == "/",
                    onClick = { oper = "/" },
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("/")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = oper == "%",
                    onClick = { oper = "%" },
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("%")
            }
        }
        Button(onClick = {
            result = operation(num1, num2, oper)
            showResult = true
        }) {
            Text("=")
        }
        if (showResult) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
            ) {
                Text(text = result, fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun operation(num1: String, num2: String, operation: String): String {
    val num1 = num1.toDoubleOrNull()
    val num2 = num2.toDoubleOrNull()

    if (num2 == null || num1 == null) {
        return "Invalid input"
    }

    return when (operation) {
        "+" -> (num1 + num2).toString()
        "-" -> (num1 - num2).toString()
        "*" -> (num1 * num2).toString()
        "/" -> if (num2 != 0.0) (num1 / num2).toString() else "Could not divide by zero"
        "%" -> if (num2 != 0.0) (num1 % num2).toString() else "Could not divide by zero"
        else -> "Invalid operation"
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleArithmeticTheme {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            arithmetic(modifier = Modifier.align(Alignment.Center))
        }
    }
}