package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun ColorPickerRGB(
    color: Color = Color.Black,
    onColorSelected: (Color) -> Unit
) {
    var red by remember { mutableFloatStateOf(color.red * 255f) }
    var green by remember { mutableFloatStateOf(color.green * 255f) }
    var blue by remember { mutableFloatStateOf(color.blue * 255f) }

    val selectedColor = Color(red / 255f, green / 255f, blue / 255f)

    Column(
        modifier = Modifier
            .background(themeColors.backPrimary)
            .padding(16.dp)
    ) {
        ColorSlider(
            colorName = "R",
            value = red,
            onValueChange = { red = it; onColorSelected(selectedColor) },
            color = themeColors.colorRed
        )
        ColorSlider(
            colorName = "G",
            value = green,
            onValueChange = { green = it; onColorSelected(selectedColor) },
            color = themeColors.colorGreen
        )
        ColorSlider(
            colorName = "B",
            value = blue,
            onValueChange = { blue = it; onColorSelected(selectedColor) },
            color = themeColors.colorBlue
        )
        Box(
            modifier = Modifier
                .border(
                    color = themeColors.backSecondary,
                    shape = RectangleShape,
                    width = 2.dp,
                )
                .fillMaxWidth()
                .height(100.dp)
                .background(selectedColor)
        )
    }
}

@Composable
private fun ColorSlider(
    colorName: String,
    value: Float,
    color: Color,
    onValueChange: (Float) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        ColorValueText(
            colorName = colorName,
            color = color,
            value = value,
        )
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = color,
                activeTrackColor = color,
                inactiveTrackColor = themeColors.backSecondary
            )
        )
    }
}

@Composable
private fun ColorValueText(
    colorName: String,
    value: Float,
    color: Color
) {
    // TODO : maybe there is better way of doing that
    val maxValueText = "R: 255"
    Box {
        Text(
            text = "$colorName: ${value.toInt()}",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            color = color,
        )
        Text(
            text = maxValueText,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            color = color,
            modifier = Modifier
                .alpha(0f)
        )
    }
}

@Preview
@Composable
private fun BlackColorPickerRGBPreview() {
    AppTheme(
        theme = MainTheme,
        darkTheme = false
    ) {
        ColorPickerRGB(
            color = Color.Black,
            onColorSelected = {}
        )
    }
}

@Preview
@Composable
private fun WhiteColorPickerRGBPreview() {
    AppTheme(
        theme = MainTheme,
        darkTheme = false,
    ) {
        ColorPickerRGB(
            color = Color.White,
            onColorSelected = {}
        )
    }
}

@Preview
@Composable
private fun BlackDarkThemeColorPickerRGBPreview() {
    AppTheme(
        theme = MainTheme,
        darkTheme = true,
    ) {
        ColorPickerRGB(
            color = Color.Black,
            onColorSelected = {}
        )
    }
}

@Preview
@Composable
private fun WhiteDarkThemeColorPickerRGBPreview() {
    AppTheme(
        theme = MainTheme,
        darkTheme = true,
    ) {
        ColorPickerRGB(
            color = Color.White,
            onColorSelected = {}
        )
    }
}
