package com.example.project_w2_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplaneTicket
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.project_w2_1.ui.theme.Project_w2_1Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project_w2_1Theme {
            }
        }
    }
}

@Composable
fun LayoutCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.AirplaneTicket, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    MyOwnColumn(modifier.padding(8.dp)) {
        Text("1")
        Text("2")
        Text("3")
        Text("4")
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) {
        measurables, constraints ->
        val placeables = measurables.map {
            measurable ->
            measurable.measure(constraints)
        }
        var yPosition = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height + 8
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutCodelabPreview() {
    Project_w2_1Theme {
        BodyContent()
    }
}
@Preview(showBackground = true)
@Composable
fun LayoutCodelabPreview2() {
    Project_w2_1Theme {
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) = this.then(
    layout {
        measurable, constraints ->
        val placeable = measurable.measure(constraints)
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val originalFirstBaseline = placeable[FirstBaseline]
        val placeableY = firstBaselineToTop.roundToPx() - originalFirstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }
)

@Composable
fun SimpleList(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val listSize = 100
    Row {
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(0)
            }
        }) {
            Text(text = "Scroll to the top")
        }
        Button(onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(listSize - 1)
            }
        }) {
            Text(text = "Scroll to the end")
        }
    }
    LazyColumn(state = scrollState, modifier = modifier) {
        items(listSize) {
            ImageListItem(it)
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item ##$index", style = MaterialTheme.typography.subtitle1)
    }
}