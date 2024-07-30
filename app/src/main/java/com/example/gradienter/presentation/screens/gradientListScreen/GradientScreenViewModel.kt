package com.example.gradienter.presentation.screens.gradientListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.usecase.settingsRepository.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.settingsRepository.GetGradientElementSizeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class GradientScreenViewModel @Inject constructor(
    private val getEditGradientItemsListUseCase: GetEditGradientItemsListUseCase,
    private val getColorRepresentationUseCase: GetColorRepresentationUseCase,
    private val getGradientElementSizeUseCase: GetGradientElementSizeUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(GradientScreenState())

    val screenState = combine(
        _screenState,
        getEditGradientItemsListUseCase(),
        getColorRepresentationUseCase(),
        getGradientElementSizeUseCase(),
    ) { state, editGradientItemsList, colorRepresentation, gradientElementSize ->
        state.copy(
            gradientItems = GradientBuilder.build(editGradientItemsList),
            colorRepresentation = colorRepresentation,
            gradientElementSize = gradientElementSize,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        GradientScreenState()
    )

    fun screenAction(action: GradientScreenAction) {

    }
}
