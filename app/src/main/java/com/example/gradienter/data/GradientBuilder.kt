package com.example.gradienter.data

import androidx.compose.ui.graphics.Color
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.models.GradientItem
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min

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

        val maxDistance = calculateMaxDistance(startColor, targetColor)
        val resultDistance = min(distance, maxDistance)

        val redStep = calculateStep(startColor.red, targetColor.red, resultDistance)
        val greenStep = calculateStep(startColor.green, targetColor.green, resultDistance)
        val blueStep = calculateStep(startColor.blue, targetColor.blue, resultDistance)

        var lastRed = startColor.red
        var lastGreen = startColor.green
        var lastBlue = startColor.blue

        repeat(resultDistance) {
            lastRed = normalizeColor(lastRed + redStep)
            lastGreen = normalizeColor(lastGreen + greenStep)
            lastBlue = normalizeColor(lastBlue + blueStep)
            colors.add(Color(
                red = lastRed,
                green = lastGreen,
                blue = lastBlue,
            ))
        }
        return colors
    }

    private fun calculateStep(
        startColor: Float,
        targetColor: Float,
        distance: Int,
    ): Float {
        val diff = targetColor - startColor
        val step = diff / (distance + 1)
        return step
    }

    private fun calculateMaxDistance(startColor: Color, targetColor: Color): Int {
        val redDiff = targetColor.red - startColor.red
        val greenDiff = targetColor.green - startColor.green
        val blueDiff = targetColor.blue - startColor.blue

        val maxDistance = max(
            abs(redDiff) * 255f,
            max(
                abs(greenDiff) * 255f,
                abs(blueDiff) * 255f,
            )
        )
        return floor(maxDistance).toInt() - 1
    }


    private fun normalizeColor(value: Float, minValue: Float = 0f, maxValue: Float = 1f) =
        min(max(value, minValue), maxValue)
}
