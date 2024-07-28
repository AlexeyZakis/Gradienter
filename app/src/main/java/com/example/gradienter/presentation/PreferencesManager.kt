package com.example.gradienter.presentation

import android.content.Context
import com.example.gradienter.data.ColorRepresentations
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    fun saveColorRepresentation(colorRepresentation: ColorRepresentations.Representation) {
        with(sharedPreferences.edit()) {
            putString(
                "color_representation",
                colorRepresentation.name
            )
            apply()
        }
    }

    fun loadColorRepresentation(): ColorRepresentations.Representation {
        val name = sharedPreferences.getString(
            "color_representation",
            ColorRepresentations.Representation.HEX8.name
        )
        return ColorRepresentations.Representation.valueOf(name!!)
    }
}
