package com.example.gradienter.domain.repository

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.models.SettingsElement
import kotlinx.coroutines.flow.StateFlow

interface SettingsRepository {
    val colorRepresentation: StateFlow<ColorRepresentations.Representation>
    val gradientElementSize: StateFlow<Int>
    fun setColorRepresentation(
        colorRepresentations: ColorRepresentations.Representation
    )
    fun setGradientElementSize(gradientElementSize: Int)
    fun getSettingsMap(): Map<String, SettingsElement>
    fun setSettingsMap(settingsMap: Map<String, Any>)
}
