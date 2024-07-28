package com.example.gradienter.presentation.screens.gradientListScreen

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.models.GradientItem

data class GradientScreenState(
    val colorRepresentation: ColorRepresentations.Representation =
        ColorRepresentations.Representation.HEX8,
    val gradientItems: List<GradientItem> = listOf()
)
