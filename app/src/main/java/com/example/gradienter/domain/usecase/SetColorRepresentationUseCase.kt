package com.example.gradienter.domain.usecase

import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.repository.SettingsRepository

class SetColorRepresentationUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(
        colorRepresentations: ColorRepresentations.Representation
    ) = settingsRepository.setColorRepresentation(colorRepresentations)
}
