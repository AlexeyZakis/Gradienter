package com.example.gradienter.ui.gradientScreen

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.models.GradientItem

data class GradientScreenState(
    val colorRepresentation: ColorRepresentations.Representation =
        ColorRepresentations.Representation.HEX,
    val gradientItems: List<GradientItem> = listOf()
)