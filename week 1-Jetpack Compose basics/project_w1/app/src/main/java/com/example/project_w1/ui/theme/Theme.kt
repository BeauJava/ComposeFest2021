package com.example.project_w1.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
        primary = Navy,
    onPrimary = Chartreuse,
        primaryVariant = Purple700,
        secondary = Teal200,
    surface = Blue,
    onSurface = Navy
)

private val LightColorPalette = lightColors(
        primary = LightBlue,
    onPrimary = Navy,
        primaryVariant = Purple700,
        secondary = Teal200,
    surface = Blue,
    onSurface = Color.White

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Project_w1Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}