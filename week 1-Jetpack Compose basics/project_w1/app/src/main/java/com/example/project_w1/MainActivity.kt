package com.example.project_w1

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project_w1.ui.theme.Project_w1Theme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project_w1Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(ss: List<String> = List(1000) { "$it" }) {
    var showOnboarding by rememberSaveable { mutableStateOf(true) }
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
    var expanded by remember { mutableStateOf(false) }
    val animationPadding by animateDpAsState(
        if (expanded) 60.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello~")
                Text(
                    text = "$name!", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Surface(
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = ("hi $name~ ").repeat(8))
                    }
                }
            }
            IconButton( onClick = { expanded = !expanded } ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(R.string.hide_you)
                    } else {
                        stringResource(R.string.show_you)
                    }
                )
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

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun newPreview2() {
    Project_w1Theme {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = List(1000) { "$it" }) { s ->
                Greeting(s)
            }
        }
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