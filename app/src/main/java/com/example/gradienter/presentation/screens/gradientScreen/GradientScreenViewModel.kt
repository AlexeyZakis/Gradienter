package com.example.gradienter.presentation.screens.gradientScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.usecase.GetEditGradientItemsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GradientScreenViewModel @Inject constructor(
    private val getEditGradientItemsListUseCase: GetEditGradientItemsListUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(GradientScreenState())
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            getEditGradientItemsListUseCase().collect { items ->
                _screenState.value = _screenState.value.copy(
                    gradientItems = GradientBuilder.build(items)
                )
            }
        }
    }

    fun screenAction(action: GradientScreenAction) {
        when (action) {
            is GradientScreenAction.OnChangeColorRepresentation ->
                changeColorRepresentation(action.colorRepresentation)
        }
    }

    private fun changeColorRepresentation(
        colorRepresentation: ColorRepresentations.Representation
    ) {
        _screenState.update {
            screenState.value.copy(
                colorRepresentation = colorRepresentation
            )
        }
    }
}
