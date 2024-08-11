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
import com.example.gradienter.data.settings.SettingsRepositoryImpl
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.usecase.gradientRepository.AddEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.EditEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemUseCase
import com.example.gradienter.domain.usecase.gradientRepository.GetEditGradientItemsListUseCase
import com.example.gradienter.domain.usecase.gradientRepository.MoveElementDownUseCase
import com.example.gradienter.domain.usecase.gradientRepository.MoveElementUpUseCase
import com.example.gradienter.domain.usecase.gradientRepository.RemoveEditGradientItemUseCase
import com.example.gradienter.domain.usecase.settingsRepository.GetSettingsUseCase
import com.example.gradienter.presentation.navigation.routes.SettingsScreenRoute
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreen
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenState
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenViewModel
import com.example.gradienter.presentation.screens.gradientListScreen.GradientListScreen
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenState
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenViewModel
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme

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
                getSettingsUseCase = GetSettingsUseCase(
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
                moveElementUpUseCase = MoveElementUpUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
                moveElementDownUseCase = MoveElementDownUseCase(
                    gradientRepository = GradientRepositoryImpl()
                ),
            ),
            navController = NavHostController(LocalContext.current)
        )
    }
}
