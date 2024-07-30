package com.example.gradienter.presentation.screens.settingsScreen

import android.content.Context
import com.example.gradienter.data.ColorRepresentations

sealed class SettingsScreenAction {
    data class OnColorRepresentationChange(
        val colorRepresentation: ColorRepresentations.Representation
    ) : SettingsScreenAction()
    data class OnGradientElementSizeChange(
        val gradientElementSize: Int
    ) : SettingsScreenAction()
    data class OnVersionClick(
        val context: Context
    ) : SettingsScreenAction()
    data object OnCheckNewVersionClick : SettingsScreenAction()
    data object OnDownloadNewVersionClick : SettingsScreenAction()
}
