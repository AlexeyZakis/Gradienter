package com.example.gradienter.presentation

import android.content.Context
import com.example.gradienter.domain.repository.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SettingsManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val settingsRepository: SettingsRepository
) {
    private val sharedPreferences =
        context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    fun save() {
        val settings = settingsRepository.getSettingsMap()
        settings.forEach { (key, settingsElement) ->
            with(sharedPreferences.edit()) {
                when (settingsElement.value) {
                    is Int -> putInt(key, settingsElement.value)
                    is Float -> putFloat(key, settingsElement.value)
                    is String -> putString(key, settingsElement.value)
                    is Boolean -> putBoolean(key, settingsElement.value)
                    is Enum<*> -> putString(key, settingsElement.value.name)
                    else -> throw IllegalArgumentException("Unsupported type")
                }
                apply()
            }
        }
    }

    fun load() {
        val settingsMap = mutableMapOf<String, Any>()
        val settings = settingsRepository.getSettingsMap()
        settings.forEach { (key, settingsElement) ->
            with(sharedPreferences) {
                val value = when (settingsElement.defaultValue) {
                    is Int -> getInt(key, settingsElement.defaultValue)
                    is Float -> getFloat(key, settingsElement.defaultValue)
                    is String -> getString(
                        key, settingsElement.defaultValue
                    ) ?: settingsElement.defaultValue

                    is Boolean -> getBoolean(key, settingsElement.defaultValue)
                    is Enum<*> -> java.lang.Enum.valueOf(
                        settingsElement.defaultValue::class.java
                                as Class<out Enum<*>>,
                        sharedPreferences.getString(
                            key, settingsElement.defaultValue.name
                        ) ?: settingsElement.defaultValue.name
                    )

                    else -> throw IllegalArgumentException("Unsupported type")
                }
                settingsMap[key] = value
            }
        }
        settingsRepository.setSettingsMap(settingsMap)
    }
}
