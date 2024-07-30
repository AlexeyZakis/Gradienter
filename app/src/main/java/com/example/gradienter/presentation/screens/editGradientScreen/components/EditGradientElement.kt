package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.gradienter.presentation.generalUiElements.DeleteBtn
import com.example.gradienter.presentation.generalUiElements.NumberSelector
import com.example.gradienter.presentation.generalUiElements.UpDownArrows
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun EditGradientElement(
    modifier: Modifier = Modifier,
    downArrowEnabled: Boolean,
    upArrowEnabled: Boolean,
    onColorChangeClick: (Color) -> Unit,
    onDistanceChange: (Int) -> Unit,
    onDeleteClick: () -> Unit,
    onUpArrowClick: () -> Unit,
    onDownArrowClick: () -> Unit,
    color: Color,
    distance: Int,
) {
    val configuration = LocalConfiguration.current
    val splitInto2Line = configuration.screenWidthDp <= 400

    Column(
        modifier = modifier
            .background(themeColors.backSecondary)
            .height(IntrinsicSize.Min)
    ) {
        if (splitInto2Line) {
            GradientColorSelector(
                color = color,
                onClick = { onColorChangeClick(color) },
                modifier = Modifier
                    .height(50.dp)
            )
        }
        Row {
            UpDownArrows(
                upArrowEnabled = upArrowEnabled,
                downArrowEnabled = downArrowEnabled,
                onUpArrowClick = onUpArrowClick,
                onDownArrowClick = onDownArrowClick,
            )
            if (!splitInto2Line) {
                GradientColorSelector(
                    color = color,
                    onClick = { onColorChangeClick(color) },
                    modifier = Modifier
                        .weight(5f)
                )
            }
            NumberSelector(
                value = distance,
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
                    .weight(1f)
            )
        }
    }
}

@Preview(
    widthDp = 500,
    heightDp = 50,
)
@Composable
private fun OneLineEditGradientElementPreview() {
    AppTheme(theme = MainTheme) {
        EditGradientElement(
            onColorChangeClick = {},
            onDistanceChange = {},
            onDeleteClick = {},
            onDownArrowClick = {},
            onUpArrowClick = {},
            downArrowEnabled = true,
            upArrowEnabled = true,
            color = Color.Green,
            distance = LocalConfiguration.current.screenWidthDp,
        )
    }
}

@Preview(
    widthDp = 400,
    heightDp = 100,
)
@Composable
private fun TwoLinesEditGradientElementPreview() {
    AppTheme(theme = MainTheme) {
        EditGradientElement(
            onColorChangeClick = {},
            onDistanceChange = {},
            onDeleteClick = {},
            onDownArrowClick = {},
            onUpArrowClick = {},
            downArrowEnabled = true,
            upArrowEnabled = true,
            color = Color.Green,
            distance = LocalConfiguration.current.screenWidthDp,
        )
    }
}
