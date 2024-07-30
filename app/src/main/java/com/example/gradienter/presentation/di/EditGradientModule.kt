package com.example.gradienter.presentation.di

import com.example.gradienter.domain.repository.GradientRepository
import com.example.gradienter.domain.usecase.gradientRepository.AddEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.EditEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.gradientRepository.RemoveEditGradientItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class EditGradientModule {
    @Provides
    fun provideGetEditItemsListUseCase(gradientRepository: GradientRepository) =
        GetEditGradientItemsListUseCase(gradientRepository = gradientRepository)

    @Provides
    fun provideGetEditGradientItemUseCase(gradientRepository: GradientRepository) =
        GetEditGradientItemUseCase(gradientRepository = gradientRepository)

    @Provides
    fun provideAddEditGradientItemUseCase(gradientRepository: GradientRepository) =
        AddEditGradientItemUseCase(gradientRepository = gradientRepository)

    @Provides
    fun provideEditEditGradientItemUseCase(gradientRepository: GradientRepository) =
        EditEditGradientItemUseCase(gradientRepository = gradientRepository)

    @Provides
    fun provideRemoveEditGradientItemUseCase(gradientRepository: GradientRepository) =
        RemoveEditGradientItemUseCase(gradientRepository = gradientRepository)
}
