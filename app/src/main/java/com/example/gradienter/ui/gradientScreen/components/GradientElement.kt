package com.example.gradienter.ui.gradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gradienter.data.BrightnessCalculator
import com.example.gradienter.data.ColorRepresentations

@Composable
fun GradientElement(
    modifier: Modifier = Modifier,
    colorRepresentation: (Color) -> (String),
    color: Color,
    onClick: () -> Unit,
    paddingValues: PaddingValues = PaddingValues(8.dp),
    fontSize: TextUnit = 20.sp,
) {
    val textColor = when(BrightnessCalculator.getBrightness(color)) {
        BrightnessCalculator.Brightness.LIGHT -> Color.Black
        BrightnessCalculator.Brightness.DARK -> Color.White
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(paddingValues)
        ,
    ) {
        Text(
            text = colorRepresentation(color),
            fontSize = fontSize,
            fontFamily = FontFamily.Monospace,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun GradientElementPreview() {
    GradientElement(
        color = Color.Green.copy(green = 0.9f),
        modifier = Modifier,
        onClick = {},
        colorRepresentation = { color -> ColorRepresentations.getColorString(
            color,
            ColorRepresentations.Representation.HEX
        ) }
    )
}