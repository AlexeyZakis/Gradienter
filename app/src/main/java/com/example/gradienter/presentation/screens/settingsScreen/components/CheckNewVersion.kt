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
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Text(
            color = themeColors.labelPrimary,
            text = stringResource(id = R.string.checkNewVersion),
        )
    }
}

@Preview
@Composable
private fun CheckNewVersionPreview() {
    CheckNewVersion(
        onClick = {},
    )
}