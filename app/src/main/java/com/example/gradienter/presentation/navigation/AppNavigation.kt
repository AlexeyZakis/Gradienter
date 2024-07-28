package com.example.gradienter.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gradienter.presentation.navigation.routes.EditGradientScreenRoute
import com.example.gradienter.presentation.navigation.routes.GradientScreenRoute
import com.example.gradienter.presentation.navigation.routes.SettingsScreenRoute
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreen
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenViewModel
import com.example.gradienter.presentation.screens.gradientScreen.GradientScreen
import com.example.gradienter.presentation.screens.gradientScreen.GradientScreenViewModel
import com.example.gradienter.presentation.screens.settingsScreen.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = GradientScreenRoute.route
    ) {
        composable(
            route = GradientScreenRoute.route,
        ) {
            val gradientScreenViewModel: GradientScreenViewModel = hiltViewModel()
            val gradientScreenState by gradientScreenViewModel.screenState.collectAsState()
            GradientScreen(
                screenState = gradientScreenState,
                screenAction = gradientScreenViewModel::screenAction,
                navigateToSettings = { navController.navigate(SettingsScreenRoute.route) },
                navigateToEditGradient = { navController.navigate(EditGradientScreenRoute.route) },
            )
        }
        composable(
            route = EditGradientScreenRoute.route,
        ) {
            val editGradientScreenViewModel: EditGradientScreenViewModel = hiltViewModel()
            val editGradientScreenState by editGradientScreenViewModel.screenState.collectAsState()
            EditGradientScreen(
                screenState = editGradientScreenState,
                screenAction = editGradientScreenViewModel::screenAction,
                navigateBack = {
                    navController.navigate(GradientScreenRoute.route) {
                        popUpTo(GradientScreenRoute.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = SettingsScreenRoute.route,
        ) {
//            val gradientScreenViewModel: GradientScreenViewModel = hiltViewModel()
//            val gradientScreenState by gradientScreenViewModel.screenState.collectAsState()
            SettingsScreen(
                navigateBack = {
                    navController.navigate(GradientScreenRoute.route) {
                        popUpTo(GradientScreenRoute.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
