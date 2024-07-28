package com.example.gradienter.presentation.screens.gradientListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.usecase.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.GetEditGradientItemsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GradientScreenViewModel @Inject constructor(
    private val getEditGradientItemsListUseCase: GetEditGradientItemsListUseCase,
    private val getColorRepresentationUseCase: GetColorRepresentationUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(GradientScreenState())

    val screenState = combine(
        _screenState,
        getEditGradientItemsListUseCase(),
        getColorRepresentationUseCase()
    ) { state, editGradientItemsList, colorRepresentation ->
        state.copy(
            gradientItems = GradientBuilder.build(editGradientItemsList),
            colorRepresentation = colorRepresentation
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        GradientScreenState()
    )

    fun screenAction(action: GradientScreenAction) {

    }
}
