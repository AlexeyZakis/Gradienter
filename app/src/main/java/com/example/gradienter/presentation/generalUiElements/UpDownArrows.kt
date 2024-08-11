package com.example.gradienter.presentation.generalUiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.theme.themeColors

@Composable
fun UpDownArrows(
    modifier: Modifier = Modifier,
    downArrowEnabled: Boolean = true,
    upArrowEnabled: Boolean = true,
    onUpArrowClick: () -> Unit,
    onDownArrowClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.background(themeColors.backSecondary)
    ) {
        IconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = themeColors.labelSecondary,
                disabledContentColor = themeColors.labelDisable
            ),
            onClick = { onUpArrowClick() },
            enabled = upArrowEnabled
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = stringResource(id = R.string.upElement)
            )
        }
        IconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = themeColors.labelSecondary,
                disabledContentColor = themeColors.labelDisable
            ),
            onClick = { onDownArrowClick() },
            enabled = downArrowEnabled
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = stringResource(id = R.string.downElement)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UpDownArrowsPreview() {
    AppTheme(theme = MainTheme) {
        UpDownArrows(
            onUpArrowClick = {},
            onDownArrowClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DownDisableUpDownArrowsPreview() {
    AppTheme(theme = MainTheme) {
        UpDownArrows(
            downArrowEnabled = false,
            onUpArrowClick = {},
            onDownArrowClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UpDisableUpDownArrowsPreview() {
    AppTheme(theme = MainTheme) {
        UpDownArrows(
            upArrowEnabled = false,
            onUpArrowClick = {},
            onDownArrowClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DisableUpDownArrowsPreview() {
    AppTheme(theme = MainTheme) {
        UpDownArrows(
            upArrowEnabled = false,
            downArrowEnabled = false,
            onUpArrowClick = {},
            onDownArrowClick = {},
        )
    }
}
