package com.example.gradienter.presentation.di

import com.example.gradienter.domain.repository.SettingsRepository
import com.example.gradienter.domain.usecase.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.SetColorRepresentationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SettingsModule {
    @Provides
    fun provideGetColorRepresentationUseCase(settingsRepository: SettingsRepository) =
        GetColorRepresentationUseCase(settingsRepository = settingsRepository)

    @Provides
    fun provideSetColorRepresentationUseCase(settingsRepository: SettingsRepository) =
        SetColorRepresentationUseCase(settingsRepository = settingsRepository)
}
