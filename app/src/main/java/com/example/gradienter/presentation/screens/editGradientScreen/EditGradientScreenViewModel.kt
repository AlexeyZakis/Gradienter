package com.example.gradienter.presentation.screens.editGradientScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.usecase.AddEditGradientItemUseCase
import com.example.gradienter.domain.usecase.EditEditGradientItemUseCase
import com.example.gradienter.domain.usecase.GetEditGradientItemUseCase
import com.example.gradienter.domain.usecase.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.RemoveEditGradientItemUseCase
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
}
