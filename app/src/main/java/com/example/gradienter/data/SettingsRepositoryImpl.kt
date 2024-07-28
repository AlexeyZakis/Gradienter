package com.example.gradienter.data

import com.example.gradienter.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsRepositoryImpl : SettingsRepository {
    private val _colorRepresentation: MutableStateFlow<ColorRepresentations.Representation> =
        MutableStateFlow(ColorRepresentations.Representation.HEX8)
    override val colorRepresentation = _colorRepresentation.asStateFlow()

    override fun setColorRepresentation(
        colorRepresentations: ColorRepresentations.Representation
    ) {
        _colorRepresentation.value = colorRepresentations
    }
}
