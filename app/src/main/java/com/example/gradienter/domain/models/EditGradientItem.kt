package com.example.gradienter.domain.models

import androidx.compose.ui.graphics.Color
import com.example.gradienter.Constants
import java.util.UUID

data class EditGradientItem(
    val id: String = UUID.randomUUID().toString(),
    val color: Color = Constants.DEFAULT_EDIT_GRADIENT_COLOR,
    val distanceToNextColor: Int = Constants.DEFAULT_EDIT_GRADIENT_DISTANCE
)
