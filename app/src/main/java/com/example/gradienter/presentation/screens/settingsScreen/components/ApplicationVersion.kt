package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.BuildConfig
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors

@Composable
fun ApplicationVersion(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val label = stringResource(id = R.string.applicationVersion)
    val version = BuildConfig.VERSION_NAME

    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Text(
            text = "$label: $version",
            color = themeColors.labelPrimary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ApplicationVersionPreview() {
    AppTheme(theme = MainTheme) {
        ApplicationVersion(
            onClick = {},
        )
    }
}
