package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors

@Composable
fun SettingsScreenWrapper(
    modifier: Modifier = Modifier,
    background: Color = themeColors.backSecondary,
    innerPadding: PaddingValues = PaddingValues(8.dp),
    outerPadding: PaddingValues = PaddingValues(8.dp),
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(outerPadding)
            .background(background)
            .padding(innerPadding)
    ) {
        content()
    }
}

@Preview
@Composable
private fun SettingsScreenWrapperPreview() {
    AppTheme(theme = MainTheme) {
        SettingsScreenWrapper {
            Text("Example")
        }
    }
}
