package com.example.gradienter

import androidx.compose.ui.graphics.Color
import com.example.gradienter.data.ColorRepresentations

object Constants {
    const val PROJECT_REPOSITORY = "https://github.com/Zakis0/Gradienter/releases/latest"

    const val DEFAULT_GRADIENT_ELEMENT_HEIGHT = 18
    val DEFAULT_COLOR_REPRESENTATION = ColorRepresentations.Representation.HEX8

    val DEFAULT_EDIT_GRADIENT_COLOR = Color.White
    const val DEFAULT_EDIT_GRADIENT_DISTANCE = 0

    const val MIN_GRADIENT_ELEMENT_HEIGHT = 1
    const val MAX_GRADIENT_ELEMENT_HEIGHT = 100
    const val GRADIENT_ELEMENT_PADDING_PERCENTAGE_OF_HEIGHT = 0.25f
}
