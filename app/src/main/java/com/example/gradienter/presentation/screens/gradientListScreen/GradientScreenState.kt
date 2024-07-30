package com.example.gradienter.presentation.screens.gradientListScreen

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.models.GradientItem
import com.example.gradienter.Constants

data class GradientScreenState(
    val gradientItems: List<GradientItem> = listOf(),
    val colorRepresentation: ColorRepresentations.Representation =
        Constants.DEFAULT_COLOR_REPRESENTATION,
    val gradientElementSize: Int =
        Constants.DEFAULT_GRADIENT_ELEMENT_HEIGHT,
)
