package com.example.gradienter.domain.usecase

import com.example.gradienter.domain.repository.SettingsRepository

class GetColorRepresentationUseCase(private val settingsRepository: SettingsRepository) {
    operator fun invoke() = settingsRepository.colorRepresentation
}
