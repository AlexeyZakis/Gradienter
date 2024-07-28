package com.example.gradienter.presentation.screens.gradientScreen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.domain.models.GradientItem

@Composable
fun GradientList(
    modifier: Modifier = Modifier,
    colorRepresentation: ColorRepresentations.Representation,
    itemsList: List<GradientItem>,
    onItemClick: (GradientItem) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = lazyListState
    ) {
        items(itemsList) { item ->
            GradientElement(
                colorRepresentation = { color ->
                    ColorRepresentations.getColorString(
                        color,
                        colorRepresentation
                    )
                },
                fontSize = 20.sp,
                color = item.color,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Preview(
    widthDp = 800,
    heightDp = 2000,
)
@Composable
private fun GradientListPreview() {
    GradientList(
        colorRepresentation = ColorRepresentations.Representation.HEX,
        onItemClick = {},
        itemsList = GradientBuilder.build(
            listOf(
                EditGradientItem(color = Color.Red, distanceToNextColor = 64),
                EditGradientItem(color = Color.Yellow, distanceToNextColor = 64),
                EditGradientItem(color = Color.Green, distanceToNextColor = 64),
                EditGradientItem(color = Color.Blue, distanceToNextColor = 64),
            )
        )
    )
}
