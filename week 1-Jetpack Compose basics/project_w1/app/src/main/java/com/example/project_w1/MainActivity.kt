package com.example.project_w1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
        setContent {
            Project_w1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview(showBackground = false, name = "no background, dark")
@Preview(showBackground = true, name = "background, dark")
@Composable
fun DefaultPreview4() {
    Project_w1Theme(darkTheme = true) {
        Greeting2("Android")
    }
}

@Preview(showBackground = false, name = "no background")
@Preview(showBackground = true, name = "background")
@Composable
fun DefaultPreview3() {
    Project_w1Theme() {
        Greeting2("Android")
    }
}

@Preview(showBackground = false, name = "surface, no background, dark")
@Preview(showBackground = true, name = "surface, background, dark")
@Composable
fun DefaultPreview2() {
    Project_w1Theme(darkTheme = true) {
        Greeting("Android")
    }
}

@Preview(showBackground = false, name = "surface, no background")
@Preview(showBackground = true, name = "surface, background")
@Composable
fun DefaultPreview() {
    Project_w1Theme() {
        Greeting("Android")
    }
}