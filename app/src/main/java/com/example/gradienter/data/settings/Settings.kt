package com.example.gradienter.data.settings

import com.example.gradienter.Constants
import com.example.gradienter.data.ColorRepresentations

data class Settings(
    val colorRepresentation: ColorRepresentations.Representation =
        Constants.DEFAULT_COLOR_REPRESENTATION,
    val gradientElementSize: Int = Constants.DEFAULT_GRADIENT_ELEMENT_HEIGHT
)
