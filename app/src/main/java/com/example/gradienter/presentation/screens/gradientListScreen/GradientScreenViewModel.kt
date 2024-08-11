package com.example.gradienter.presentation.screens.gradientListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.settingsRepository.GetSettingsUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class GradientScreenViewModel @Inject constructor(
    private val getEditGradientItemsListUseCase: GetEditGradientItemsListUseCase,
    private val getSettingsUseCase: GetSettingsUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(GradientScreenState())
    val screenState = combine(
        _screenState,
        getEditGradientItemsListUseCase(),
        getSettingsUseCase(),
    ) { state, editGradientItemsList, settings ->
        state.copy(
            gradientItems = GradientBuilder.build(editGradientItemsList),
            colorRepresentation = settings.colorRepresentation,
            gradientElementSize = settings.gradientElementSize,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        GradientScreenState()
    )

    fun screenAction(action: GradientScreenAction) {

    }
}
