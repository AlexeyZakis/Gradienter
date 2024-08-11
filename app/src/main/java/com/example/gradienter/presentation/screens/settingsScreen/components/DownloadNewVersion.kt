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
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors

@Composable
fun DownloadNewVersion(
    modifier: Modifier = Modifier,
    isDownloading: Boolean,
    versionName: String,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
            .clickable(enabled = !isDownloading) { onClick() }
            .padding(8.dp)
    ) {
        Text(
            color = themeColors.labelPrimary,
            text = if (isDownloading) {
                stringResource(id = R.string.downloading)
            } else {
                "${stringResource(id = R.string.downloadLatestVersion)}: " +
                        versionName
            },
        )
    }
}

@Preview
@Composable
private fun IsNotDownloadingDownloadNewVersionPreview() {
    AppTheme(theme = MainTheme) {
        DownloadNewVersion(
            isDownloading = false,
            versionName = "v1.3.0",
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun DownloadingDownloadNewVersionPreview() {
    AppTheme(theme = MainTheme) {
        DownloadNewVersion(
            isDownloading = true,
            versionName = "v1.3.0",
            onClick = {},
        )
    }
}
