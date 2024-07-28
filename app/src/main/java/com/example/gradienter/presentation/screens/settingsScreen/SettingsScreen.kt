package com.example.gradienter.presentation.screens.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.presentation.generalUiElements.BottomSheet
import com.example.gradienter.presentation.screens.settingsScreen.components.SettingsColorRepresentationSelector
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.gradienter.presentation.utils.extensions.toRId
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(
    screenState: SettingsScreenState,
    screenAction: (SettingsScreenAction) -> Unit,
    navigateBack: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val sheetState: ModalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Box(
        modifier = Modifier
            .background(themeColors.backPrimary)
    ) {
        BottomSheet(
            sheetState = sheetState,
            values = ColorRepresentations.Representation.entries.toTypedArray(),
            valueToStringResId = { representation -> representation.toRId() },
            selected = screenState.colorRepresentation,
            onSelect = { representation ->
                screenAction(SettingsScreenAction.OnColorRepresentationChange(representation))
            }
        ) {
            Column {
                SettingsColorRepresentationSelector(
                    colorRepresentation = screenState.colorRepresentation,
                    onClick = {
                        scope.launch {
                            sheetState.show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    AppTheme(theme = MainTheme) {
        SettingsScreen(
            screenState = SettingsScreenState(),
            screenAction = {},
            navigateBack = {},
        )
    }
}
