package com.example.gradienter.presentation.utils.extensions

import com.example.gradienter.R
import com.example.gradienter.data.ColorRepresentations

fun ColorRepresentations.Representation.toRId() = when (this) {
    ColorRepresentations.Representation.HEX6 -> R.string.colorRepresentationHex6
    ColorRepresentations.Representation.HEX8 -> R.string.colorRepresentationHex8
    ColorRepresentations.Representation.RGBA_INT -> R.string.colorRepresentationRgbaInt
    ColorRepresentations.Representation.RGBA_FLOAT -> R.string.colorRepresentationRgbaFloat
    ColorRepresentations.Representation.NONE -> R.string.colorRepresentationNone
}
