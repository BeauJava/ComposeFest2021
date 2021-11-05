package com.example.project_w1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_w1.ui.theme.Project_w1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { }
    }
}

@Composable
fun MyApp(ss: List<String> = listOf("android", "compose", "codelab", "gdg")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (s in ss) {
            Greeting(s)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello~")
                Text(text = "$name!")
            }
            OutlinedButton(
                onClick = {},
                modifier = Modifier.align(CenterVertically)
            ) {
                Text("show you " + name)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun newPreview() {
    Project_w1Theme {
        MyApp()
    }
}