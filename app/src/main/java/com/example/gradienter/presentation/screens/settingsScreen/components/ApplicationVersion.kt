package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.BuildConfig
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun ApplicationVersion() {
    val label = stringResource(id = R.string.applicationVersion)
    val version = BuildConfig.VERSION_NAME
    Text(
        text = "$label: v$version",
        color = themeColors.labelPrimary,
    )
}

@Preview(showBackground = true)
@Composable
private fun ApplicationVersionPreview() {
    AppTheme(theme = MainTheme) {
        ApplicationVersion()
    }
}
