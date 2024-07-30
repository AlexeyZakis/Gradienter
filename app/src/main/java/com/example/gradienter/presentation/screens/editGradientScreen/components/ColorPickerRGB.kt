package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.presentation.generalUiElements.ValueSlider
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun ColorPickerRGB(
    color: Color = Color.Black,
    onColorChange: (Color) -> Unit
) {
    var red by remember { mutableFloatStateOf(color.red * 255f) }
    var green by remember { mutableFloatStateOf(color.green * 255f) }
    var blue by remember { mutableFloatStateOf(color.blue * 255f) }

    Column(
        modifier = Modifier
            .background(themeColors.backPrimary)
            .padding(16.dp)
    ) {
        ValueSlider(
            valueName = "R",
            value = red,
            minValue = 0f,
            maxValue = 255f,
            sliderColor = themeColors.colorRed,
            sliderBackgroundColor = themeColors.backSecondary,
            onValueChange = {
                red = it
                onColorChange(Color(
                    red = red / 255f,
                    green = green / 255f,
                    blue = blue / 255f
                ))
            },
        )
        ValueSlider(
            valueName = "G",
            value = green,
            minValue = 0f,
            maxValue = 255f,
            sliderColor = themeColors.colorGreen,
            sliderBackgroundColor = themeColors.backSecondary,
            onValueChange = {
                green = it
                onColorChange(Color(
                    red = red / 255f,
                    green = green / 255f,
                    blue = blue / 255f
                ))
            },
        )
        ValueSlider(
            valueName = "B",
            value = blue,
            minValue = 0f,
            maxValue = 255f,
            sliderColor = themeColors.colorBlue,
            sliderBackgroundColor = themeColors.backSecondary,
            onValueChange = {
                blue = it
                onColorChange(Color(
                    red = red / 255f,
                    green = green / 255f,
                    blue = blue / 255f
                ))
            },
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
                .background(Color(
                    red = red / 255f,
                    green = green / 255f,
                    blue = blue / 255f
                ))
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
            onColorChange = {}
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
            onColorChange = {}
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
            onColorChange = {}
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
            onColorChange = {}
        )
    }
}
