package com.example.gradienter.presentation.screens.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.presentation.generalUiElements.BottomSheet
import com.example.gradienter.presentation.screens.settingsScreen.components.ApplicationVersion
import com.example.gradienter.presentation.screens.settingsScreen.components.CheckNewVersion
import com.example.gradienter.presentation.screens.settingsScreen.components.DownloadNewVersion
import com.example.gradienter.presentation.screens.settingsScreen.components.GradientElementSizeSelector
import com.example.gradienter.presentation.screens.settingsScreen.components.GradientListExample
import com.example.gradienter.presentation.screens.settingsScreen.components.SettingsColorRepresentationSelector
import com.example.gradienter.presentation.screens.settingsScreen.components.SettingsScreenWrapper
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
    val context = LocalContext.current

    val scope = rememberCoroutineScope()
    val sheetState: ModalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
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
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(scrollState)
            ) {
                SettingsScreenWrapper(
                    innerPadding = PaddingValues(0.dp)
                ) {
                    SettingsColorRepresentationSelector(
                        colorRepresentation = screenState.colorRepresentation,
                        onClick = {
                            scope.launch {
                                sheetState.show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                SettingsScreenWrapper {
                    GradientElementSizeSelector(
                        initValue = screenState.gradientElementSize,
                        onValueChange = { size ->
                            screenAction(SettingsScreenAction.OnGradientElementSizeChange(size))
                        }
                    )
                }
                SettingsScreenWrapper {
                    GradientListExample(
                        gradientElementHeightDp = screenState.gradientElementSize,
                        colorRepresentation = screenState.colorRepresentation,
                    )
                }
                SettingsScreenWrapper(
                    innerPadding = PaddingValues(0.dp)
                ) {
                    ApplicationVersion(
                        onClick = {
                            screenAction(SettingsScreenAction.OnVersionClick(context))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                SettingsScreenWrapper(
                    innerPadding = PaddingValues(0.dp)
                ) {
                    CheckNewVersion(
                        onClick = {
                            screenAction(SettingsScreenAction.OnCheckNewVersionClick)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                if (screenState.hasNewVersion) {
                    SettingsScreenWrapper(
                        innerPadding = PaddingValues(0.dp)
                    ) {
                        DownloadNewVersion(
                            isDownloading = screenState.isDownloading,
                            versionName = screenState.newVersionName,
                            onClick = {
                                screenAction(SettingsScreenAction.OnDownloadNewVersionClick)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
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
