package com.example.gradienter.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorNames(
    val labelPrimary: Color,
    val labelSecondary: Color,
    val labelTertiary: Color,
    val labelDisable: Color,

    val backPrimary: Color,
    val backSecondary: Color,
    val backTertiary: Color,

    val colorRed: Color,
    val colorGreen: Color,
    val colorBlue: Color,
    val colorGray: Color,
    val colorGreyLight: Color,
    val colorWhite: Color,
)

val LocalColorNames = staticCompositionLocalOf {
    ColorNames(
        labelPrimary = Color.Unspecified,
        labelSecondary = Color.Unspecified,
        labelTertiary = Color.Unspecified,
        labelDisable = Color.Unspecified,

        backPrimary = Color.Unspecified,
        backSecondary = Color.Unspecified,
        backTertiary = Color.Unspecified,

        colorRed = Color.Unspecified,
        colorGreen = Color.Unspecified,
        colorBlue = Color.Unspecified,
        colorGray = Color.Unspecified,
        colorGreyLight = Color.Unspecified,
        colorWhite = Color.Unspecified,
    )
}
