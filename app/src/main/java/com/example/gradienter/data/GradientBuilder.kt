package com.example.gradienter.data

import androidx.compose.ui.graphics.Color
import com.example.gradienter.data.models.GradientItem
import java.lang.Float.max
import java.lang.Float.min

object GradientBuilder {
    fun build(colorDotsParams: List<ColorDotsParam>): List<GradientItem> {
        val gradientList = mutableListOf<GradientItem>()

        for (i in 0 ..< colorDotsParams.lastIndex) {
            val colors = getColors(
                startColor = colorDotsParams[i].color,
                targetColor = colorDotsParams[i + 1].color,
                distance = colorDotsParams[i].distanceToNextColor
            )
            colors.forEach { color ->
                    gradientList.add(GradientItem(color = color))
            }
        }
        gradientList.add(GradientItem(colorDotsParams.last().color))
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
            colors.add(Color(
                red = normalizeColor(colors.last().red + redStep),
                green = normalizeColor(colors.last().green + greenStep),
                blue = normalizeColor(colors.last().blue + blueStep),
            ))
        }
        return colors
    }
    private fun normalizeColor(value: Float, minValue: Float = 0f, maxValue: Float = 1f) =
        min(max(value, minValue), maxValue)
    class ColorDotsParam(val color: Color, val distanceToNextColor: Int = 0)
}