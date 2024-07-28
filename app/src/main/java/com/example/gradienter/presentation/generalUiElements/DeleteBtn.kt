package com.example.gradienter.presentation.generalUiElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun DeleteBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        colors = IconButtonDefaults.filledTonalIconButtonColors(
            containerColor = Color.White.copy(alpha = 0f),
            contentColor = themeColors.colorWhite,
            disabledContentColor = themeColors.labelDisable
        ),
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.deleteBtn)
        )
    }
}

@Preview
@Composable
fun DeleteBtnPreview() {
    AppTheme(theme = MainTheme) {
        DeleteBtn(
            onClick = {},
        )
    }
}
