package com.example.gradienter.data.settings

import com.example.gradienter.Constants
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.models.SettingsElement
import com.example.gradienter.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsRepositoryImpl : SettingsRepository {
    private val _settings = MutableStateFlow(Settings())
    override val settings = _settings.asStateFlow()

    override fun setSettings(settings: Settings) {
        _settings.value = settings
    }

    override fun getSettingsMap(): Map<String, SettingsElement> =
        mapOf(
            Keys.COLOR_REPRESENTATION_KEY to SettingsElement(
                value = _settings.value.colorRepresentation,
                defaultValue = ColorRepresentations.Representation.HEX6
            ),
            Keys.GRADIENT_ELEMENT_SIZE_KEY to SettingsElement(
                value = _settings.value.gradientElementSize,
                defaultValue = Constants.DEFAULT_GRADIENT_ELEMENT_HEIGHT
            ),
        )

    override fun setSettingsMap(settingsMap: Map<String, Any>) {
        _settings.value = _settings.value.copy(
            colorRepresentation = settingsMap[Keys.COLOR_REPRESENTATION_KEY] as ColorRepresentations.Representation,
            gradientElementSize = settingsMap[Keys.GRADIENT_ELEMENT_SIZE_KEY] as Int
        )
    }

    private object Keys {
        const val COLOR_REPRESENTATION_KEY = "colorRepresentation"
        const val GRADIENT_ELEMENT_SIZE_KEY = "gradientElementSize"
    }
}
