package com.alex.gimenes.apps.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Gray_FF383838F,
    primaryVariant = White_FFFFFFFF,
    secondary = Gray_FF838282,
    secondaryVariant = Purple_FFAE7BD3,
    surface = Gray_2B2E32,
    background = Gray_14171B
)

private val LightColorPalette = lightColors(
    primary = White_FFFFFFFF,
    primaryVariant = Black_FF020202,
    secondary = Gray_FFA7A7A7,
    secondaryVariant = Gray_FFBDBDBD,
    surface = Gray_FAFAFA,
    background = Gray_FDFDFD
)

@Composable
fun ModularizationAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
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