package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.utils.extensions.toRId
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun SettingsColorRepresentationSelector(
    modifier: Modifier = Modifier,
    colorRepresentation: ColorRepresentations.Representation,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(themeColors.backSecondary)
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Text(
            color = themeColors.labelPrimary,
            text = stringResource(id = R.string.currentColorRepresentation) +
                    ": " +
                    stringResource(id = colorRepresentation.toRId()),
        )
    }
}

@Preview
@Composable
private fun SettingsColorRepresentationSelectorPreview() {
    AppTheme(theme = MainTheme) {
        SettingsColorRepresentationSelector(
            colorRepresentation = ColorRepresentations.Representation.HEX8,
            onClick = {},
        )
    }
}