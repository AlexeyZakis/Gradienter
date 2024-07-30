package com.example.gradienter.presentation.screens.settingsScreen

import com.example.gradienter.data.ColorRepresentations

sealed class SettingsScreenAction {
    data class OnColorRepresentationChange(
        val colorRepresentation: ColorRepresentations.Representation
    ) : SettingsScreenAction()
    data class OnGradientElementSizeChange(
        val gradientElementSize: Int
    ) : SettingsScreenAction()
}
