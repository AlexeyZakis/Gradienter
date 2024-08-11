package com.example.gradienter.presentation.di

import com.example.gradienter.domain.repository.SettingsRepository
import com.example.gradienter.domain.usecase.settingsRepository.GetSettingsUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetSettingsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SettingsModule {
    @Provides
    fun provideGetSettingsUseCase(settingsRepository: SettingsRepository) =
        GetSettingsUseCase(settingsRepository = settingsRepository)

    @Provides
    fun provideSetSettingsUseCase(settingsRepository: SettingsRepository) =
        SetSettingsUseCase(settingsRepository = settingsRepository)
}
