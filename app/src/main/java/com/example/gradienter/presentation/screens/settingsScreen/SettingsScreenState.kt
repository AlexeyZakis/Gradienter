package com.example.gradienter.presentation.screens.settingsScreen

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.Constants

data class SettingsScreenState(
    val colorRepresentation: ColorRepresentations.Representation =
        Constants.DEFAULT_COLOR_REPRESENTATION,
    val gradientElementSize: Int =
        Constants.DEFAULT_GRADIENT_ELEMENT_HEIGHT,
)
