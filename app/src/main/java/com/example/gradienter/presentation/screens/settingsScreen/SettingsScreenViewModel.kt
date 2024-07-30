package com.example.gradienter.presentation.screens.settingsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.usecase.settingsRepository.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.settingsRepository.GetGradientElementSizeUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetGradientElementSizeUseCase
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val getColorRepresentationUseCase: GetColorRepresentationUseCase,
    private val setColorRepresentationUseCase: SetColorRepresentationUseCase,
    private val getGradientElementSizeUseCase: GetGradientElementSizeUseCase,
    private val setGradientElementSizeUseCase: SetGradientElementSizeUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(SettingsScreenState())
    val screenState = combine(
        _screenState,
        getGradientElementSizeUseCase(),
        getColorRepresentationUseCase()
    ) { state, gradientElementSize, colorRepresentation ->
        state.copy(
            gradientElementSize = gradientElementSize,
            colorRepresentation = colorRepresentation
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        SettingsScreenState()
    )

    fun screenAction(action: SettingsScreenAction) {
        when (action) {
            is SettingsScreenAction.OnColorRepresentationChange ->
                changeColorRepresentation(action.colorRepresentation)
            is SettingsScreenAction.OnGradientElementSizeChange ->
                changeGradientElementSize(action.gradientElementSize)
        }
    }

    private fun changeColorRepresentation(
        colorRepresentation: ColorRepresentations.Representation
    ) {
        setColorRepresentationUseCase(colorRepresentation)
    }
    private fun changeGradientElementSize(gradientElementSize: Int) {
        setGradientElementSizeUseCase(gradientElementSize)
    }
}
