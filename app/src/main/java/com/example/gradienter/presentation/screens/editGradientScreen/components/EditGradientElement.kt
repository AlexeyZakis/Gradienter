package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.R
import com.example.gradienter.presentation.generalUiElements.DeleteBtn
import com.example.gradienter.presentation.generalUiElements.NumberSelector
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun EditGradientElement(
    modifier: Modifier = Modifier,
    onColorChangeClick: (Color) -> Unit,
    onDistanceChange: (Int) -> Unit,
    onDeleteClick: () -> Unit,
    color: Color,
    distance: Int,
) {
    Row(
        modifier = modifier
            .background(themeColors.backSecondary)
            .height(IntrinsicSize.Min)
    ) {
        GradientColorSelector(
            color = color,
            onClick = { onColorChangeClick(color) },
            modifier = Modifier
                .weight(1f)
        )
        NumberSelector(
            value = distance,
            hint = stringResource(id = R.string.distanceToNextColor),
            onValueChange = onDistanceChange,
            modifier = Modifier
                .wrapContentWidth()
        )
        DeleteBtn(
            onClick = { onDeleteClick() },
            modifier = Modifier
                .fillMaxHeight()
                .background(themeColors.colorRed)
                .wrapContentWidth()
        )
    }
}

@Preview
@Composable
private fun EditGradientElementPreview() {
    AppTheme(theme = MainTheme) {
        EditGradientElement(
            onColorChangeClick = {},
            onDistanceChange = {},
            onDeleteClick = {},
            color = Color.Green,
            distance = 122,
        )
    }
}
