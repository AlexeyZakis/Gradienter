package com.example.gradienter.presentation.screens.settingsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.usecase.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.SetColorRepresentationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val getColorRepresentationUseCase: GetColorRepresentationUseCase,
    private val setColorRepresentationUseCase: SetColorRepresentationUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(SettingsScreenState())
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            getColorRepresentationUseCase().collect { colorRepresentation ->
                _screenState.value = _screenState.value.copy(
                    colorRepresentation = colorRepresentation
                )
            }
        }
    }

    fun screenAction(action: SettingsScreenAction) {
        when (action) {
            is SettingsScreenAction.OnColorRepresentationChange ->
                changeColorRepresentation(action.colorRepresentation)
        }
    }

    private fun changeColorRepresentation(
        colorRepresentation: ColorRepresentations.Representation
    ) {
        setColorRepresentationUseCase(colorRepresentation)
    }
}
