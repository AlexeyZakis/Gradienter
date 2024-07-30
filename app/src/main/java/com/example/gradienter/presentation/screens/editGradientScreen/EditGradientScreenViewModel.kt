package com.example.gradienter.presentation.screens.editGradientScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.usecase.gradientRepository.AddEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.EditEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.gradientRepository.MoveElementDownUseCase
import com.example.gradienter.domain.usecase.gradientRepository.MoveElementUpUseCase
import com.example.gradienter.domain.usecase.gradientRepository.RemoveEditGradientItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditGradientScreenViewModel @Inject constructor(
    private val getEditGradientItemsListUseCase: GetEditGradientItemsListUseCase,
    private val getEditGradientItemUseCase: GetEditGradientItemUseCase,
    private val addEditGradientItemUseCase: AddEditGradientItemUseCase,
    private val removeEditGradientItemUseCase: RemoveEditGradientItemUseCase,
    private val editEditGradientItemUseCase: EditEditGradientItemUseCase,
    private val moveElementUpUseCase: MoveElementUpUseCase,
    private val moveElementDownUseCase: MoveElementDownUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(EditGradientScreenState())
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            getEditGradientItemsListUseCase().collect { items ->
                _screenState.value = _screenState.value.copy(
                    editGradientItems = items
                )
            }
        }
    }

    fun screenAction(action: EditGradientScreenAction) {
        when (action) {
            is EditGradientScreenAction.OnAddNewElementClick ->
                addNewEditGradientItem()

            is EditGradientScreenAction.OnChangeElementColor ->
                updateEditGradientItemColor(
                    editGradientItemId = action.editGradientItemId,
                    color = action.color
                )

            is EditGradientScreenAction.OnChangeElementDistance ->
                updateEditGradientItemDistance(
                    editGradientItemId = action.editGradientItemId,
                    distance = action.distance
                )

            is EditGradientScreenAction.OnDeleteElement ->
                deleteEditGradientItem(
                    editGradientItem = action.editGradientItem,
                )

            is EditGradientScreenAction.OnDownArrowClick ->
                moveElementDown(
                    editGradientItem = action.editGradientItem,
                )

            is EditGradientScreenAction.OnUpArrowClick ->
                moveElementUp(
                    editGradientItem = action.editGradientItem,
                )
        }
    }

    private fun addNewEditGradientItem() {
        addEditGradientItemUseCase(EditGradientItem())
    }

    private fun updateEditGradientItemColor(
        editGradientItemId: String,
        color: Color,
    ) {
        val editGradientItem = getEditGradientItemUseCase(editGradientItemId)
        editGradientItem?.let {
            editEditGradientItemUseCase(
                it.copy(
                    color = color
                )
            )
        }
    }

    private fun updateEditGradientItemDistance(
        editGradientItemId: String,
        distance: Int,
    ) {
        val editGradientItem = getEditGradientItemUseCase(editGradientItemId)
        editGradientItem?.let {
            editEditGradientItemUseCase(
                it.copy(
                    distanceToNextColor = distance
                )
            )
        }
    }

    private fun deleteEditGradientItem(editGradientItem: EditGradientItem) {
        removeEditGradientItemUseCase(editGradientItem = editGradientItem)
    }

    private fun moveElementUp(editGradientItem: EditGradientItem) {
        moveElementUpUseCase(editGradientItem)
    }

    private fun moveElementDown(editGradientItem: EditGradientItem) {
        moveElementDownUseCase(editGradientItem)
    }
}
