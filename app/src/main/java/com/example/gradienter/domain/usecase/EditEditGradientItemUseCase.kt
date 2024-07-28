package com.example.gradienter.domain.usecase

import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.repository.GradientRepository

class EditEditGradientItemUseCase(private val gradientRepository: GradientRepository) {
    operator fun invoke(editGradientItem: EditGradientItem) =
        gradientRepository.editEditGradientItem(editGradientItem = editGradientItem)
}
