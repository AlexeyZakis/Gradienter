package com.example.todoapp.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gradienter.ui.gradientScreen.GradientScreen
import com.example.gradienter.ui.gradientScreen.GradientScreenViewModel
import com.example.gradienter.ui.navigation.routes.GradientScreenRoute

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
                screenAction = gradientScreenViewModel::screenAction
            )
        }
    }
}
