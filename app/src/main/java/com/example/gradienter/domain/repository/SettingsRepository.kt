package com.example.gradienter.domain.repository

import com.example.gradienter.data.ColorRepresentations
import kotlinx.coroutines.flow.StateFlow

interface SettingsRepository {
    val colorRepresentation: StateFlow<ColorRepresentations.Representation>
    fun setColorRepresentation(
        colorRepresentations: ColorRepresentations.Representation
    )
}
