package com.example.project_w1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun MyApp(ss: List<String> = listOf("android", "compose", "codelab")) {
    Column {
        for (s in ss) {
            Greeting(s)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "Hello~")
            Text(text = "$name!")
        }
    }
}

@Preview(showBackground = false)
@Composable
fun newPreview() {
    Project_w1Theme {
        MyApp()
    }
}