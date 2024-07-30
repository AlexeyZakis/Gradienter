package com.example.gradienter.domain.usecase.settingsRepository

import com.example.gradienter.domain.repository.SettingsRepository

class SetGradientElementSizeUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(gradientElementSize: Int) =
        settingsRepository.setGradientElementSize(gradientElementSize)
}
