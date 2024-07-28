package com.example.gradienter.presentation.di

import com.example.gradienter.data.GradientRepositoryImpl
import com.example.gradienter.domain.repository.GradientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GradientRepositoryModule {
    @Provides
    @Singleton
    fun provideGradientRepository(): GradientRepository =
        GradientRepositoryImpl()
}
