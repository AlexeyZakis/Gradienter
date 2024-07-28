package com.example.gradienter.presentation.screens.gradientListScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun GradientListBottom(
    isLandscape: Boolean,
    navigateToEditGradient: () -> Unit,
    navigateToSettings: () -> Unit,
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
    ) {
        if (!isLandscape) {
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

@Preview
@Composable
private fun LandscapeGradientListBottomPreview() {
    GradientListBottom(
        isLandscape = true,
        navigateToEditGradient = {},
        navigateToSettings = {},
    )
}

@Preview
@Composable
private fun PortraitGradientListBottomPreview() {
    GradientListBottom(
        isLandscape = false,
        navigateToEditGradient = {},
        navigateToSettings = {},
    )
}