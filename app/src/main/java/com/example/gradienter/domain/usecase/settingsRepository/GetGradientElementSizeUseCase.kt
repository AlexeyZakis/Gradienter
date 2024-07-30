package com.example.gradienter.domain.usecase.settingsRepository

import com.example.gradienter.domain.repository.SettingsRepository

class GetGradientElementSizeUseCase(private val settingsRepository: SettingsRepository) {
    operator fun invoke() = settingsRepository.gradientElementSize
}
