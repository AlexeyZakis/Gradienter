package com.example.gradienter.domain.repository

import com.example.gradienter.data.settings.Settings
import com.example.gradienter.domain.models.SettingsElement
import kotlinx.coroutines.flow.StateFlow

interface SettingsRepository {
    val settings: StateFlow<Settings>
    fun setSettings(settings: Settings)
    fun getSettingsMap(): Map<String, SettingsElement>
    fun setSettingsMap(settingsMap: Map<String, Any>)
}
