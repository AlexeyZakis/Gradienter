package com.example.gradienter.ui.gradientScreen

import com.example.gradienter.data.ColorRepresentations

sealed class GradientScreenAction {
    data class OnChangeColorRepresentation(
        val colorRepresentation: ColorRepresentations.Representation
    ) : GradientScreenAction()
    data object Nothing : GradientScreenAction()
}