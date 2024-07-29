package com.example.gradienter.presentation.generalUiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun NumberSelector(
    modifier: Modifier = Modifier,
    value: Int,
    onValueChange: (Int) -> Unit,
    hint: String = "",
) {
    var textState by remember { mutableStateOf(TextFieldValue(value.toString())) }

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
            onClick = {
                val currentValue = textState.text.toIntOrNull() ?: 0
                if (currentValue > 0) {
                    textState = TextFieldValue((currentValue - 1).toString())
                }
                onValueChange(textState.text.toInt())
            },
            enabled = (textState.text.toIntOrNull() ?: 0) > 0
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = stringResource(id = R.string.decreasesValue)
            )
        }

        BasicTextField(
            value = textState,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            textStyle = TextStyle(
                color = themeColors.labelPrimary,
                textAlign = TextAlign.Center
            ),
            onValueChange = { value ->
                if (value.text.all { char -> char.isDigit() }) {
                    textState = value
                    onValueChange(value.text.toIntOrNull() ?: 0)
                }
            },
            modifier = Modifier
                .width(100.dp)
                .background(color = themeColors.backTertiary)
        ) { textField ->
            Box(modifier = Modifier.padding(16.dp)) {
                if (textState.text.isEmpty()) {
                    Text(
                        text = hint,
                        style = MaterialTheme.typography.bodyMedium,
                        color = themeColors.labelTertiary
                    )
                }
                textField()
            }
        }

        IconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = themeColors.labelSecondary,
                disabledContentColor = themeColors.labelDisable
            ),
            onClick = {
                val currentValue = textState.text.toIntOrNull() ?: 0
                textState = TextFieldValue((currentValue + 1).toString())
                onValueChange(currentValue + 1)
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.increasesValue)
            )
        }
    }
}

@Preview
@Composable
fun NumberSelectorPreview() {
    AppTheme(theme = MainTheme) {
        NumberSelector(
            value = 0,
            hint = "Number",
            onValueChange = {},
        )
    }
}

@Preview
@Composable
fun NumberSelectorPreview2() {
    AppTheme(theme = MainTheme) {
        NumberSelector(
            value = 124,
            hint = "Number",
            onValueChange = {},
        )
    }
}
