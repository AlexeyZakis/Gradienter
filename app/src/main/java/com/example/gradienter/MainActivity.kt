package com.example.gradienter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gradienter.domain.repository.SettingsRepository
import com.example.gradienter.presentation.SettingsManager
import com.example.gradienter.presentation.screens.adaptiveScreen.AdaptiveScreen
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var settingsManager: SettingsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        settingsManager.load()

        setContent {
            AppTheme(theme = MainTheme) {
                AdaptiveScreen()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        settingsManager.save()
    }
}
