package com.example.gradienter.domain.usecase.settingsRepository

import com.example.gradienter.domain.repository.SettingsRepository

class GetSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke() = settingsRepository.settings
}
