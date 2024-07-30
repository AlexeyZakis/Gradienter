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
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun CheckNewVersion(
    modifier: Modifier = Modifier,
    hasNewVersion: Boolean,
    versionName: String,
    onCheckNewVersionClick: () -> Unit,
    onOpenNewVersionInfoClick: () -> Unit,
) {
    val onClick = if (hasNewVersion) {
        onOpenNewVersionInfoClick
    } else {
        onCheckNewVersionClick
    }
    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Text(
            color = themeColors.labelPrimary,
            text = if (hasNewVersion) {
                "${stringResource(id = R.string.latestVersionInfo)}: " +
                    versionName
            } else {
                stringResource(id = R.string.checkNewVersion)
            },
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun HasNewVersionCheckNewVersionPreview() {
    CheckNewVersion(
        hasNewVersion = true,
        versionName = "v1.3.0",
        onCheckNewVersionClick = {},
        onOpenNewVersionInfoClick = {},
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun NoNewVersionCheckNewVersionPreview() {
    CheckNewVersion(
        hasNewVersion = false,
        versionName = "v1.3.0",
        onCheckNewVersionClick = {},
        onOpenNewVersionInfoClick = {},
    )
}
