package com.example.gradienter.domain.usecase.gradientRepository

import com.example.gradienter.domain.repository.GradientRepository

class GetEditGradientItemsListUseCase(private val gradientRepository: GradientRepository) {
    operator fun invoke() = gradientRepository.editGradientItems
}
