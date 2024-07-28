package com.example.gradienter.data

import androidx.compose.ui.graphics.Color

object BrightnessCalculator {
    private fun calculateBrightness(color: Color) =
        0.299 * color.red +
                0.587 * color.green +
                0.114 * color.blue

    fun getBrightness(color: Color): Brightness {
        val brightness = calculateBrightness(color)
        return if (brightness > 0.5f) {
            Brightness.LIGHT
        } else {
            Brightness.DARK
        }
    }

    enum class Brightness {
        LIGHT,
        DARK,
    }
}