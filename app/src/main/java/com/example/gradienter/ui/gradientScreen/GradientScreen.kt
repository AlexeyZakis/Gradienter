package com.example.gradienter.ui.gradientScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.ui.gradientScreen.components.Gradient

@Composable
fun GradientScreen(
    screenState: GradientScreenState,
    screenAction: (GradientScreenAction) -> Unit,
) {
    val clipboardManager = LocalClipboardManager.current

    Gradient(
        colorRepresentation = screenState.colorRepresentation,
        listItems = screenState.gradientItems,
        onItemClick = { item ->
            clipboardManager.setText(AnnotatedString(
                ColorRepresentations.getColorString(
                    item.color,
                    screenState.colorRepresentation
                )
            ))
        }
    )
}

@Preview
@Composable
fun GradientScreenPreview() {
    GradientScreen(
        screenState = GradientScreenState(
            gradientItems = GradientBuilder.build(
                listOf(
                    GradientBuilder.ColorDotsParam(Color.Red, 15),
                    GradientBuilder.ColorDotsParam(Color.Yellow, 15),
                    GradientBuilder.ColorDotsParam(Color.Green, 15),
                    GradientBuilder.ColorDotsParam(Color.Blue, 15),
                )
            )
        ),
        screenAction = {}
    )
}