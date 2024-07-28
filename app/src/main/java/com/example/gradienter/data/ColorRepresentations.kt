package com.example.gradienter.data

import androidx.compose.ui.graphics.Color

object ColorRepresentations {
    fun getColorString(color: Color, representation: Representation) =
        when (representation) {
            Representation.HEX -> hex(color)
            Representation.RGBA_INT -> rgbaInt(color)
            Representation.RGBA_FLOAT -> rgbaFloat(color)
        }

    private fun hex(color: Color): String {
        val alpha = (color.alpha * 255).toInt()
        val red = (color.red * 255).toInt()
        val green = (color.green * 255).toInt()
        val blue = (color.blue * 255).toInt()
        return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
    }

    private fun rgbaInt(color: Color): String {
        val alpha = (color.alpha * 255).toInt()
        val red = (color.red * 255).toInt()
        val green = (color.green * 255).toInt()
        val blue = (color.blue * 255).toInt()
        return "($red, $green, $blue, $alpha)"
    }

    private fun rgbaFloat(color: Color): String {
        val alpha = color.alpha
        val red = color.red
        val green = color.green
        val blue = color.blue
        return "($red, $green, $blue, $alpha)"
    }

    enum class Representation {
        HEX,
        RGBA_INT,
        RGBA_FLOAT,
    }
}
