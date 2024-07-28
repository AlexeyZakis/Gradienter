package com.example.gradienter.presentation.screens.gradientScreen

import com.example.gradienter.data.ColorRepresentations

sealed class GradientScreenAction {
    data class OnChangeColorRepresentation(
        val colorRepresentation: ColorRepresentations.Representation
    ) : GradientScreenAction()
}
