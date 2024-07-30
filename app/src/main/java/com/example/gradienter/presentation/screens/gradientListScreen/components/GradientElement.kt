package com.example.gradienter.presentation.screens.gradientListScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gradienter.Constants
import com.example.gradienter.data.BrightnessCalculator
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme

@Composable
fun GradientElement(
    modifier: Modifier = Modifier,
    colorRepresentation: (Color) -> (String),
    color: Color,
    height: Dp,
    paddingPercentageOfHeight: Float =
        Constants.GRADIENT_ELEMENT_PADDING_PERCENTAGE_OF_HEIGHT,
    onClick: () -> Unit,
) {
    val textColor = when (BrightnessCalculator.getBrightness(color)) {
        BrightnessCalculator.Brightness.LIGHT -> Color.Black
        BrightnessCalculator.Brightness.DARK -> Color.White
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color)
            .clickable { onClick() }
            .padding(height * paddingPercentageOfHeight)
            .height(height)
            .fillMaxWidth()
    ) {
        Text(
            text = colorRepresentation(color),
            fontFamily = FontFamily.Monospace,
            style = TextStyle.Default,
            textAlign = TextAlign.Center,
            color = textColor,
            fontSize = with(LocalDensity.current) { height.toSp() }
        )
    }
}

@Preview
@Composable
private fun GradientElementPreview() {
    AppTheme(theme = MainTheme) {
        GradientElement(
            height = 18.dp,
            color = Color.Green.copy(green = 0.9f),
            modifier = Modifier,
            onClick = {},
            colorRepresentation = { color ->
                ColorRepresentations.getColorString(
                    color,
                    ColorRepresentations.Representation.HEX8
                )
            }
        )
    }
}
