package com.example.gradienter.ui.gradientScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GradientScreenViewModel : ViewModel() {
    private val _screenState = MutableStateFlow(GradientScreenState())
    val screenState = _screenState.asStateFlow()

    init {
        _screenState.update {
            screenState.value.copy(
                gradientItems = GradientBuilder.build(
                    listOf(
                        GradientBuilder.ColorDotsParam(Color.Red, 15),
                        GradientBuilder.ColorDotsParam(Color.Yellow, 15),
                        GradientBuilder.ColorDotsParam(Color.Green, 15),
                        GradientBuilder.ColorDotsParam(Color.Blue, 15),
                    )
                )
            )
        }
    }

    fun screenAction(action: GradientScreenAction) {
        when (action) {
            is GradientScreenAction.OnChangeColorRepresentation ->
                changeColorRepresentation(action.colorRepresentation)
            else -> {}
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