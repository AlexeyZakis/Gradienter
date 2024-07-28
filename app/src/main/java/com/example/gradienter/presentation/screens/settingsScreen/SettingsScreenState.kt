package com.example.gradienter.presentation.screens.settingsScreen

import com.example.gradienter.data.ColorRepresentations

data class SettingsScreenState(
    val colorRepresentation: ColorRepresentations.Representation =
        ColorRepresentations.Representation.HEX8
)
