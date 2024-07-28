package com.example.gradienter.presentation.screens.gradientScreen

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.models.GradientItem

data class GradientScreenState(
    val colorRepresentation: ColorRepresentations.Representation =
        ColorRepresentations.Representation.HEX,
    val gradientItems: List<GradientItem> = listOf()
)
