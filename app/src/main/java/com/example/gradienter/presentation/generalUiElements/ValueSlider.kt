package com.example.gradienter.presentation.generalUiElements

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.max
import kotlin.math.min

@Composable
fun ValueSlider(
    valueName: String,
    valueNameMaxLengthSample: String = valueName,
    value: Float,
    minValue: Float = 0f,
    maxValue: Float,
    sliderColor: Color,
    valueNameColor: Color = sliderColor,
    sliderBackgroundColor: Color,
    wrapSliderToNewLine: Boolean = false,
    onValueChange: (Float) -> Unit,
) {
    val normalizedValue = normalizeValue(
        value = value,
        minValue = minValue,
        maxValue = maxValue
    )
    AdaptiveContainer(
        isRow = !wrapSliderToNewLine
    ) {
        ColorValueText(
            colorName = valueName,
            maxTextSample = valueNameMaxLengthSample,
            maxValue = maxValue,
            color = valueNameColor,
            value = normalizedValue,
        )
        Slider(
            value = normalizedValue,
            onValueChange = onValueChange,
            valueRange = minValue..maxValue,
            colors = SliderDefaults.colors(
                thumbColor = sliderColor,
                activeTrackColor = sliderColor,
                inactiveTrackColor = sliderBackgroundColor,
            )
        )
    }
}

@Composable
private fun ColorValueText(
    colorName: String,
    maxTextSample: String,
    maxValue: Float,
    value: Float,
    color: Color
) {
    Box {
        Text(
            text = "$colorName: ${value.toInt()}",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            color = color,
        )
        // TODO : maybe there is a better way of doing that
        Text(
            text = "$maxTextSample: ${maxValue.toInt()}",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            color = color,
            modifier = Modifier.alpha(0f)
        )
    }
}

private fun normalizeValue(value: Float, minValue: Float, maxValue: Float) =
    min(max(value, minValue), maxValue)

@Preview
@Composable
private fun NoMaxTextSampleValueSliderPreview() {
    ValueSlider(
        valueName = "R",
        value = 123f,
        minValue = 0f,
        maxValue = 255f,
        sliderColor = Color.Red,
        sliderBackgroundColor = Color.Gray,
        valueNameColor = Color.Yellow,
        onValueChange = {},
    )
}

@Preview
@Composable
private fun WithMaxTextSampleValueSliderPreview() {
    ValueSlider(
        valueName = "R",
        valueNameMaxLengthSample = "R",
        value = 260f,
        minValue = 0f,
        maxValue = 255f,
        sliderColor = Color.Red,
        sliderBackgroundColor = Color.Gray,
        onValueChange = {},
    )
}
