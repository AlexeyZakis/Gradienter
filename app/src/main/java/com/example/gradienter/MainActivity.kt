package com.example.gradienter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gradienter.ui.theme.GradienterTheme
import com.example.todoapp.presentation.screens.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradienterTheme {
                AppNavigation()
            }
        }
    }
}
