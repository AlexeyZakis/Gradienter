package com.example.gradienter.presentation.screens.adaptiveScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.gradienter.presentation.navigation.AppNavigation
import com.example.gradienter.presentation.navigation.LandscapeTabletAppNavigation

@Composable
fun AdaptiveScreen() {
    Box {
        if (isLandscapeTablet()) {
            LandscapeTabletAppNavigation()
        } else {
            AppNavigation()
        }
    }
}

@Composable
private fun isLandscapeTablet(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE &&
            configuration.screenHeightDp >= 600
}
