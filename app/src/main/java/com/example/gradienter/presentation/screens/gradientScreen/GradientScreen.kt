package com.example.gradienter.presentation.screens.gradientScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.presentation.screens.gradientScreen.components.GradientList
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun GradientScreen(
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
        Row(
            modifier = Modifier
                .wrapContentHeight()
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = themeColors.backTertiary
                ),
                onClick = { navigateToEditGradient() },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(
                    color = themeColors.labelPrimary,
                    text = stringResource(id = R.string.editGradient)
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = themeColors.backTertiary
                ),
                onClick = { navigateToSettings() },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(
                    color = themeColors.labelPrimary,
                    text = stringResource(id = R.string.settingsScreen)
                )
            }
        }
    }
}

@Preview
@Composable
fun GradientScreenPreview() {
    AppTheme(theme = MainTheme) {
        GradientScreen(
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
