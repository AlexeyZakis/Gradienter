package com.example.gradienter.presentation.screens.editGradientScreen

import androidx.compose.ui.graphics.Color
import com.example.gradienter.domain.models.EditGradientItem

sealed class EditGradientScreenAction {
    data object OnAddNewElementClick : EditGradientScreenAction()
    data class OnChangeElementColor(
        val editGradientItemId: String,
        val color: Color,
    ) : EditGradientScreenAction()

    data class OnChangeElementDistance(
        val editGradientItemId: String,
        val distance: Int,
    ) : EditGradientScreenAction()

    data class OnDeleteElement(
        val editGradientItem: EditGradientItem,
    ) : EditGradientScreenAction()
}
