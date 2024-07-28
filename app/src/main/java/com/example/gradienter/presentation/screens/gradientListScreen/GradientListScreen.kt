package com.example.gradienter.presentation.screens.gradientListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.presentation.screens.gradientListScreen.components.GradientList
import com.example.gradienter.presentation.screens.gradientListScreen.components.GradientListBottom
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun GradientListScreen(
    screenState: GradientScreenState,
    screenAction: (GradientScreenAction) -> Unit,
    navigateToEditGradient: () -> Unit,
    navigateToSettings: () -> Unit,
) {
    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = Modifier
            .background(themeColors.backPrimary)
    ) {
        GradientList(
            modifier = Modifier.weight(1f),
            colorRepresentation = screenState.colorRepresentation,
            itemsList = screenState.gradientItems,
            onItemClick = { item ->
                if (screenState.colorRepresentation.isNone()) {
                    return@GradientList
                }
                clipboardManager.setText(
                    AnnotatedString(
                        ColorRepresentations.getColorString(
                            item.color,
                            screenState.colorRepresentation
                        )
                    )
                )
            }
        )
        GradientListBottom(
            navigateToSettings = navigateToSettings,
            navigateToEditGradient = navigateToEditGradient,
        )
    }
}

@Preview
@Composable
fun GradientListScreenPreview() {
    AppTheme(theme = MainTheme) {
        GradientListScreen(
            screenState = GradientScreenState(
                gradientItems = GradientBuilder.build(
                    listOf(
                        EditGradientItem(color = Color.Red, distanceToNextColor = 64),
                        EditGradientItem(color = Color.Yellow, distanceToNextColor = 64),
                        EditGradientItem(color = Color.Green, distanceToNextColor = 64),
                        EditGradientItem(color = Color.Blue, distanceToNextColor = 64),
                    )
                )
            ),
            screenAction = {},
            navigateToEditGradient = {},
            navigateToSettings = {},
        )
    }
}
