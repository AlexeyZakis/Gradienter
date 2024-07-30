package com.example.gradienter.domain.repository

import com.example.gradienter.domain.models.EditGradientItem
import kotlinx.coroutines.flow.StateFlow

interface GradientRepository {
    val editGradientItems: StateFlow<List<EditGradientItem>>

    fun getEditGradientItemUseCase(editGradientItemId: String): EditGradientItem?
    fun addEditGradientItem(editGradientItem: EditGradientItem)
    fun removeEditGradientItem(editGradientItem: EditGradientItem)
    fun editEditGradientItem(editGradientItem: EditGradientItem)
    fun moveElementUp(editGradientItem: EditGradientItem)
    fun moveElementDown(editGradientItem: EditGradientItem)
}
