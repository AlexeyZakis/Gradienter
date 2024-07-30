package com.example.gradienter.domain.usecase.gradientRepository

import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.repository.GradientRepository

class MoveElementUpUseCase(private val gradientRepository: GradientRepository) {
    operator fun invoke(editGradientItem: EditGradientItem) =
        gradientRepository.moveElementUp(editGradientItem = editGradientItem)
}
