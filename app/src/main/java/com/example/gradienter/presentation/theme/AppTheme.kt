package com.example.todoapp.presentation.themes

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.presentation.theme.ColorNames
import com.example.gradienter.presentation.theme.LocalColorNames
import com.example.gradienter.presentation.theme.Theme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme

@Composable
fun AppTheme(
    theme: Theme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val themeColors = if (darkTheme) {
        ColorNames(
            labelPrimary = theme.darkLabelPrimary,
            labelSecondary = theme.darkLabelSecondary,
            labelTertiary = theme.darkLabelTertiary,
            labelDisable = theme.darkLabelDisable,


            backPrimary = theme.darkBackPrimary,
            backSecondary = theme.darkBackSecondary,
            backTertiary = theme.darkBackTertiary,

            colorRed = theme.darkRed,
            colorGreen = theme.darkGreen,
            colorBlue = theme.darkBlue,
            colorGray = theme.darkGray,
            colorGreyLight = theme.darkGrayLight,
            colorWhite = theme.darkWhite,
        )
    } else {
        ColorNames(
            labelPrimary = theme.lightLabelPrimary,
            labelSecondary = theme.lightLabelSecondary,
            labelTertiary = theme.lightLabelTertiary,
            labelDisable = theme.lightLabelDisable,

            backPrimary = theme.lightBackPrimary,
            backSecondary = theme.lightBackSecondary,
            backTertiary = theme.lightBackTertiary,

            colorRed = theme.lightRed,
            colorGreen = theme.lightGreen,
            colorBlue = theme.lightBlue,
            colorGray = theme.lightGray,
            colorGreyLight = theme.lightGrayLight,
            colorWhite = theme.lightWhite,
        )
    }
    CompositionLocalProvider(LocalColorNames provides themeColors) {
        MaterialTheme(
            colorScheme = if (isSystemInDarkTheme()) {
                darkColorScheme()
            } else {
                lightColorScheme()
            },
            content = content
        )
    }
}

val themeColors: ColorNames
    @Composable
    get() = LocalColorNames.current

@Preview(
    showBackground = true,
    widthDp = 2000,
    heightDp = 500
)
@Composable
private fun AppThemeLightPreview(
    theme: Theme = MainTheme
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Label [Light] / Primary",
                colorValue = theme.lightLabelPrimary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Label [Light] / Secondary",
                colorValue = theme.lightLabelSecondary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Label [Light] / Tertiary",
                colorValue = theme.lightLabelTertiary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Label [Light] / Disable",
                colorValue = theme.lightLabelDisable,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Back [Light] / Primary",
                colorValue = theme.lightBackPrimary,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Back [Light] / Secondary",
                colorValue = theme.lightBackSecondary,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Back [Light] / Tertiary",
                colorValue = theme.lightBackTertiary,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Color [Light] / Red",
                colorValue = theme.lightRed,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Light] / Green",
                colorValue = theme.lightGreen,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Light] / Blue",
                colorValue = theme.lightBlue,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Light] / Gray",
                colorValue = theme.lightGray,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Light] / Gray Light",
                colorValue = theme.lightGrayLight,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Color [Light] / White",
                colorValue = theme.lightWhite,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 2000,
    heightDp = 500
)
@Composable
private fun AppThemeDarkPreview(
    theme: Theme = MainTheme
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Label [Dark] / Primary",
                colorValue = theme.darkLabelPrimary,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Label [Dark] / Secondary",
                colorValue = theme.darkLabelSecondary,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Label [Dark] / Tertiary",
                colorValue = theme.darkLabelTertiary,
                modifier = Modifier.padding(end = 8.dp)
            )
            ColorPreviewElement(
                colorName = "Label [Dark] / Disable",
                colorValue = theme.darkLabelDisable,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Back [Dark] / Primary",
                colorValue = theme.darkBackPrimary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Back [Dark] / Secondary",
                colorValue = theme.darkBackSecondary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Back [Dark] / Tertiary",
                colorValue = theme.darkBackTertiary,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            ColorPreviewElement(
                colorName = "Color [Dark] / Red",
                colorValue = theme.darkRed,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Dark] / Green",
                colorValue = theme.darkGreen,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Dark] / Blue",
                colorValue = theme.darkBlue,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Dark] / Gray",
                colorValue = theme.darkGray,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Dark] / Gray Light",
                colorValue = theme.darkGrayLight,
                modifier = Modifier.padding(end = 8.dp),
                isTextColorDark = false
            )
            ColorPreviewElement(
                colorName = "Color [Dark] / White",
                colorValue = theme.darkWhite,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Composable
private fun ColorPreviewElement(
    colorName: String,
    colorValue: Color,
    modifier: Modifier = Modifier,
    isTextColorDark: Boolean = true
) {
    val textColor = if (isTextColorDark) {
        Color.Black
    } else {
        Color.White
    }
    Column(
        modifier = modifier
            .background(color = colorValue)
            .width(300.dp)
    ) {
        Text(
            text = colorName,
            color = textColor,
            modifier = Modifier.padding(start = 8.dp, top = 40.dp)
        )
        Text(
            text = colorToHex(colorValue),
            color = textColor,
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
        )
    }
}

private fun colorToHex(color: Color): String {
    val alpha = (color.alpha * 255).toInt()
    val red = (color.red * 255).toInt()
    val green = (color.green * 255).toInt()
    val blue = (color.blue * 255).toInt()
    return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
}