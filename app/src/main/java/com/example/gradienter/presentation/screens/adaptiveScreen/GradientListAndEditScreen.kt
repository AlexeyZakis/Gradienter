package com.example.gradienter.presentation.screens.adaptiveScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.data.GradientRepositoryImpl
import com.example.gradienter.data.SettingsRepositoryImpl
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.usecase.AddEditGradientItemUseCase
import com.example.gradienter.domain.usecase.EditEditGradientItemUseCase
import com.example.gradienter.domain.usecase.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.GetEditGradientItemUseCase
import com.example.gradienter.domain.usecase.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.RemoveEditGradientItemUseCase
import com.example.gradienter.presentation.navigation.routes.SettingsScreenRoute
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreen
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenState
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenViewModel
import com.example.gradienter.presentation.screens.gradientListScreen.GradientListScreen
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenState
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenViewModel
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme

@Composable
fun GradientListAndEditScreen(
    gradientScreenViewModel: GradientScreenViewModel,
    gradientScreenState: GradientScreenState,
    editGradientScreenViewModel: EditGradientScreenViewModel,
    editGradientScreenState: EditGradientScreenState,
    navController: NavHostController,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.weight(1f)) {
            EditGradientScreen(
                screenState = editGradientScreenState,
                screenAction = editGradientScreenViewModel::screenAction,
                navigateBack = {}
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            GradientListScreen(
                isSplitScreen = true,
                screenState = gradientScreenState,
                screenAction = gradientScreenViewModel::screenAction,
                navigateToSettings = { navController.navigate(SettingsScreenRoute.route) },
                navigateToEditGradient = {},
            )
        }
    }
}

@Preview(
    heightDp = 500,
    widthDp = 1000
)
@Composable
private fun LandscapeGradientListAndEditScreenPreview() {
    AppTheme(theme = MainTheme) {
        val editGradientItems = listOf(
            EditGradientItem(color = Color.Red, distanceToNextColor = 64),
            EditGradientItem(color = Color.Yellow, distanceToNextColor = 64),
            EditGradientItem(color = Color.Green, distanceToNextColor = 64),
            EditGradientItem(color = Color.Blue, distanceToNextColor = 64),
        )
        GradientListAndEditScreen(
            gradientScreenState = GradientScreenState(
                gradientItems = GradientBuilder.build(
                    editGradientItems
                )
            ),
            editGradientScreenState = EditGradientScreenState(editGradientItems),
            gradientScreenViewModel = GradientScreenViewModel(
                getEditGradientItemsListUseCase = GetEditGradientItemsListUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                getColorRepresentationUseCase = GetColorRepresentationUseCase(
                    settingsRepository = SettingsRepositoryImpl()
                )
            ),
            editGradientScreenViewModel = EditGradientScreenViewModel(
                getEditGradientItemsListUseCase = GetEditGradientItemsListUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                getEditGradientItemUseCase = GetEditGradientItemUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                addEditGradientItemUseCase = AddEditGradientItemUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                removeEditGradientItemUseCase = RemoveEditGradientItemUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                editEditGradientItemUseCase = EditEditGradientItemUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
            ),
            navController = NavHostController(LocalContext.current)
        )
    }
}
