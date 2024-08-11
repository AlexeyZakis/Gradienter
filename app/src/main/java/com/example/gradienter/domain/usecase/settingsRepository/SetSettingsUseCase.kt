package com.example.gradienter.domain.usecase.settingsRepository

import com.example.gradienter.data.settings.Settings
import com.example.gradienter.domain.repository.SettingsRepository

class SetSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(settings: Settings) = settingsRepository.setSettings(settings)
}
