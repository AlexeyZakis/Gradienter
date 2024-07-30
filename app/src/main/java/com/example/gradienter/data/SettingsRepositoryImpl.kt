package com.example.gradienter.data

import com.example.gradienter.domain.models.SettingsElement
import com.example.gradienter.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsRepositoryImpl : SettingsRepository {
    private val _colorRepresentation: MutableStateFlow<ColorRepresentations.Representation> =
        MutableStateFlow(ColorRepresentations.Representation.HEX6)
    override val colorRepresentation = _colorRepresentation.asStateFlow()

    private val _gradientElementSize: MutableStateFlow<Int> =
        MutableStateFlow(18)
    override val gradientElementSize = _gradientElementSize.asStateFlow()

    override fun setColorRepresentation(
        colorRepresentations: ColorRepresentations.Representation
    ) {
        _colorRepresentation.value = colorRepresentations
    }

    override fun setGradientElementSize(gradientElementSize: Int) {
        _gradientElementSize.value = gradientElementSize
    }

    override fun getSettingsMap(): Map<String, SettingsElement> =
        mapOf(
            Keys.COLOR_REPRESENTATION_KEY to SettingsElement(
                value = _colorRepresentation.value,
                defaultValue = ColorRepresentations.Representation.HEX6
            ),
            Keys.GRADIENT_ELEMENT_SIZE_KEY to SettingsElement(
                value = _gradientElementSize.value,
                defaultValue = 18
            ),
        )

    override fun setSettingsMap(settingsMap: Map<String, Any>) {
        _colorRepresentation.value =
            settingsMap[Keys.COLOR_REPRESENTATION_KEY] as ColorRepresentations.Representation
        _gradientElementSize.value = settingsMap[Keys.GRADIENT_ELEMENT_SIZE_KEY] as Int
    }

    private object Keys {
        const val COLOR_REPRESENTATION_KEY = "colorRepresentation"
        const val GRADIENT_ELEMENT_SIZE_KEY = "gradientElementSize"
    }
}
