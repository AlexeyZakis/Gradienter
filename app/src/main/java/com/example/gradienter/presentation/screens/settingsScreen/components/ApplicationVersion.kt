package com.example.gradienter.presentation.screens.settingsScreen.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.BuildConfig
import com.example.gradienter.Constants
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun ApplicationVersion(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val label = stringResource(id = R.string.applicationVersion)
    val version = BuildConfig.VERSION_NAME

    Box(
        contentAlignment = androidx.compose.ui.Alignment.Center,
        modifier = modifier
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse(
                        Constants.PROJECT_REPOSITORY
                    )
                )
                context.startActivity(intent)
            }
            .padding(8.dp)
    ) {
        Text(
            text = "$label: v$version",
            color = themeColors.labelPrimary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ApplicationVersionPreview() {
    AppTheme(theme = MainTheme) {
        ApplicationVersion()
    }
}
