package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
            colorName = "Red",
            value = red,
            onValueChange = { red = it; onColorSelected(selectedColor) },
            color = Color.Red
        )
        ColorSlider(
            colorName = "Green",
            value = green,
            onValueChange = { green = it; onColorSelected(selectedColor) },
            color = Color.Green
        )
        ColorSlider(
            colorName = "Blue",
            value = blue,
            onValueChange = { blue = it; onColorSelected(selectedColor) },
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
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
    onValueChange: (Float) -> Unit,
    color: Color
) {
    Column {
        Text(
            text = "$colorName: ${value.toInt()}",
            fontSize = 18.sp,
            color = color
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

@Preview
@Composable
private fun ColorPickerRGBPreview() {
    AppTheme(
        theme = MainTheme,
        darkTheme = false
    ) {
        ColorPickerRGB(
            onColorSelected = {}
        )
    }
}
