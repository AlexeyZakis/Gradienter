package com.example.gradienter.presentation.theme

import androidx.compose.ui.graphics.Color

abstract class Theme {
    // Light
    abstract val lightLabelPrimary: Color
    abstract val lightLabelSecondary: Color
    abstract val lightLabelTertiary: Color
    abstract val lightLabelDisable: Color

    abstract val lightBackPrimary: Color
    abstract val lightBackSecondary: Color
    abstract val lightBackTertiary: Color

    abstract val lightRed: Color
    abstract val lightGreen: Color
    abstract val lightBlue: Color
    abstract val lightGray: Color
    abstract val lightGrayLight: Color
    abstract val lightWhite: Color

    // Dark
    abstract val darkLabelPrimary: Color
    abstract val darkLabelSecondary: Color
    abstract val darkLabelTertiary: Color
    abstract val darkLabelDisable: Color

    abstract val darkBackPrimary: Color
    abstract val darkBackSecondary: Color
    abstract val darkBackTertiary: Color

    abstract val darkRed: Color
    abstract val darkGreen: Color
    abstract val darkBlue: Color
    abstract val darkGray: Color
    abstract val darkGrayLight: Color
    abstract val darkWhite: Color
}
