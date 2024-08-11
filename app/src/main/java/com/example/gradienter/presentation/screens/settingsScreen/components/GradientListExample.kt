package com.example.gradienter.presentation.screens.settingsScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.presentation.screens.gradientListScreen.components.GradientList
import com.example.gradienter.presentation.theme.AppTheme
import com.example.gradienter.presentation.theme.mainTheme.MainTheme

@Composable
fun GradientListExample(
    gradientElementHeightDp: Int,
    colorRepresentation: ColorRepresentations.Representation,
) {
    Box(
        // TODO : maybe there is a better way of doing that
        modifier = Modifier.height(300.dp)
    ) {
        GradientList(
            colorRepresentation = colorRepresentation,
            onItemClick = {},
            gradientElementHeightDp = gradientElementHeightDp,
            itemsList = GradientBuilder.build(
                listOf(
                    EditGradientItem(color = Color.White, distanceToNextColor = 2),
                    EditGradientItem(color = Color.Black),
                )
            )
        )
    }
}

@Preview
@Composable
private fun GradientListExamplePreview() {
    AppTheme(theme = MainTheme) {
        GradientListExample(
            gradientElementHeightDp = 18,
            colorRepresentation = ColorRepresentations.Representation.HEX6,
        )
    }
}
