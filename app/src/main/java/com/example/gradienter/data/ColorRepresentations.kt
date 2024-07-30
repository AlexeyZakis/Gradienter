package com.example.gradienter.data

import androidx.compose.ui.graphics.Color

object ColorRepresentations {
    fun getColorString(color: Color, representation: Representation) =
        when (representation) {
            Representation.HEX6 -> hex6(color)
            Representation.HEX8 -> hex8(color)
            Representation.RGBA_INT -> rgbaInt(color)
            Representation.RGBA_FLOAT -> rgbaFloat(color)
            Representation.NONE -> ""
        }

    private fun hex8(color: Color): String {
        val alpha = (color.alpha * 255).toInt()
        val red = (color.red * 255).toInt()
        val green = (color.green * 255).toInt()
        val blue = (color.blue * 255).toInt()
        return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
    }

    private fun hex6(color: Color): String {
        val red = (color.red * 255).toInt()
        val green = (color.green * 255).toInt()
        val blue = (color.blue * 255).toInt()
        return String.format("#%02X%02X%02X", red, green, blue)
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
        return String.format("(%.3f, %.3f, %.3f, %.3f)", red, green, blue, alpha)
    }

    enum class Representation {
        HEX6,
        HEX8,
        RGBA_INT,
        RGBA_FLOAT,
        NONE,
        ;
        fun isNone() = this == NONE
    }
}
