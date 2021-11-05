package com.example.project_w1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_w1.ui.theme.Project_w1Theme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { }
    }
}

@Composable
fun MyApp(ss: List<String> = List(1000) { "$it" }) {
    var showOnboarding by remember { mutableStateOf(false) }
    if (showOnboarding) {
        board { showOnboarding = false }
    } else {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = ss) { s ->
                Greeting(s)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = if (expanded.value) 40.dp else 0.dp)
            ) {
                Text(text = "Hello~")
                Text(text = "$name!")
                if (expanded.value) {
                    Surface(
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = name)
                    }
                }
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
                modifier = Modifier.align(CenterVertically)
            ) {
                Text((if (expanded.value) "hide you " else "show you ") + name)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun newPreview() {
    Project_w1Theme {
        MyApp()
    }
}

@Composable
fun board(callback: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hello android")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = callback
            ) {
                Text("Continue")
            }
        }
    }
}