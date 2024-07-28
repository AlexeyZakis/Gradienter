package com.example.gradienter.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gradienter.presentation.navigation.routes.AdaptiveScreenRoute
import com.example.gradienter.presentation.navigation.routes.GradientScreenRoute
import com.example.gradienter.presentation.navigation.routes.SettingsScreenRoute
import com.example.gradienter.presentation.screens.adaptiveScreen.GradientListAndEditScreen
import com.example.gradienter.presentation.screens.editGradientScreen.EditGradientScreenViewModel
import com.example.gradienter.presentation.screens.gradientListScreen.GradientScreenViewModel
import com.example.gradienter.presentation.screens.settingsScreen.SettingsScreen
import com.example.gradienter.presentation.screens.settingsScreen.SettingsScreenViewModel

@Composable
fun LandscapeTabletAppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AdaptiveScreenRoute.route
    ) {
        composable(
            route = AdaptiveScreenRoute.route,
        ) {
            val gradientScreenViewModel: GradientScreenViewModel = hiltViewModel()
            val gradientScreenState by gradientScreenViewModel.screenState.collectAsState()

            val editGradientScreenViewModel: EditGradientScreenViewModel = hiltViewModel()
            val editGradientScreenState by editGradientScreenViewModel.screenState.collectAsState()

            GradientListAndEditScreen(
                gradientScreenViewModel = gradientScreenViewModel,
                gradientScreenState = gradientScreenState,
                editGradientScreenViewModel = editGradientScreenViewModel,
                editGradientScreenState = editGradientScreenState,
                navController = navController,
            )
        }
        composable(
            route = SettingsScreenRoute.route,
        ) {
            val settingsScreenViewModel: SettingsScreenViewModel = hiltViewModel()
            val settingsScreenState by settingsScreenViewModel.screenState.collectAsState()
            SettingsScreen(
                screenState = settingsScreenState,
                screenAction = settingsScreenViewModel::screenAction,
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
