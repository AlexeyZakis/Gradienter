package com.example.gradienter.data

import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.repository.GradientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GradientRepositoryImpl : GradientRepository {
    private val _editGradientItems: MutableStateFlow<List<EditGradientItem>> =
        MutableStateFlow(emptyList())
    override val editGradientItems = _editGradientItems.asStateFlow()

    override fun getEditGradientItemUseCase(editGradientItemId: String) =
        _editGradientItems.value.find { it.id == editGradientItemId }

    override fun addEditGradientItem(editGradientItem: EditGradientItem) {
        val newItems = _editGradientItems.value.toMutableList()
        newItems.add(editGradientItem)
        _editGradientItems.value = newItems
    }

    override fun removeEditGradientItem(editGradientItem: EditGradientItem) {
        val newItems = _editGradientItems.value.filter {
            it.id != editGradientItem.id
        }
        _editGradientItems.value = newItems
    }

    override fun editEditGradientItem(editGradientItem: EditGradientItem) {
        val newItems = _editGradientItems.value.map { item ->
            if (item.id == editGradientItem.id) {
                editGradientItem
            } else {
                item
            }
        }
        _editGradientItems.value = newItems
    }

    override fun moveElementUp(editGradientItem: EditGradientItem) {
        val newItems = _editGradientItems.value.toMutableList().apply {
            val index = this.indexOfFirst { it.id == editGradientItem.id }

            if (index > 0) {
                this[index] = this[index - 1]
                    .also { this[index - 1] = this[index] }
            }
        }
        _editGradientItems.value = newItems
    }

    override fun moveElementDown(editGradientItem: EditGradientItem) {
        val newItems = _editGradientItems.value.toMutableList().apply {
            val index = this.indexOfFirst { it.id == editGradientItem.id }

            if (index in 0..<this.size - 1) {
                this[index] = this[index + 1].also { this[index + 1] = this[index] }
            }
        }
        _editGradientItems.value = newItems
    }
}
