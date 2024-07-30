package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.R
import com.example.gradienter.Constants
import com.example.gradienter.presentation.generalUiElements.ValueSlider
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun GradientElementSizeSelector(
    initValue: Int,
    onValueChange: (Int) -> Unit
) {
    var value by remember { mutableFloatStateOf(initValue.toFloat()) }

    ValueSlider(
        value = value,
        minValue = Constants.MIN_GRADIENT_ELEMENT_HEIGHT.toFloat(),
        maxValue = Constants.MAX_GRADIENT_ELEMENT_HEIGHT.toFloat(),
        wrapSliderToNewLine = true,
        valueName = stringResource(id = R.string.gradientElementSize),
        sliderColor = themeColors.labelPrimary,
        sliderBackgroundColor = themeColors.colorGreyLight,
        onValueChange = { value = it; onValueChange(value.toInt()) },
    )
}

@Preview
@Composable
private fun GradientElementSizeSelectorPreview() {
    AppTheme(theme = MainTheme) {
        GradientElementSizeSelector(
            initValue = 5,
            onValueChange = {},
        )
    }
}
