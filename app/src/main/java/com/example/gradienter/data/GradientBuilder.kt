package com.example.gradienter.data

import androidx.compose.ui.graphics.Color
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.models.GradientItem
import java.lang.Float.max
import java.lang.Float.min

object GradientBuilder {
    fun build(
        editGradientItems: List<EditGradientItem>,
        collapseConsecutiveColorDuplicates: Boolean = false,
    ): List<GradientItem> {
        val gradientList = mutableListOf<GradientItem>()
        if (editGradientItems.isEmpty()) {
            return gradientList
        }

        for (i in 0..<editGradientItems.lastIndex) {
            val colors = getColors(
                startColor = editGradientItems[i].color,
                targetColor = editGradientItems[i + 1].color,
                distance = editGradientItems[i].distanceToNextColor
            )
            colors.forEach { color ->
                if (collapseConsecutiveColorDuplicates &&
                    gradientList.isNotEmpty() &&
                    gradientList.last().color == color
                ) {
                    return@forEach
                }
                gradientList.add(GradientItem(color = color))
            }
        }
        if (collapseConsecutiveColorDuplicates &&
            gradientList.isNotEmpty() &&
            gradientList.last().color == editGradientItems.last().color
        ) {
            return gradientList
        }
        gradientList.add(GradientItem(editGradientItems.last().color))
        return gradientList
    }

    // [startColor, targetColor)
    private fun getColors(startColor: Color, targetColor: Color, distance: Int): List<Color> {
        val colors = mutableListOf(startColor)
        if (distance < 0) {
            return colors
        }

        val redStep = (targetColor.red - startColor.red) / (distance + 1)
        val greenStep = (targetColor.green - startColor.green) / (distance + 1)
        val blueStep = (targetColor.blue - startColor.blue) / (distance + 1)

        repeat(distance) {
            colors.add(
                Color(
                    red = normalizeColor(colors.last().red + redStep),
                    green = normalizeColor(colors.last().green + greenStep),
                    blue = normalizeColor(colors.last().blue + blueStep),
                )
            )
        }
        return colors
    }

    private fun normalizeColor(value: Float, minValue: Float = 0f, maxValue: Float = 1f) =
        min(max(value, minValue), maxValue)
}
