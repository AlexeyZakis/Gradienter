package com.example.gradienter.ui.gradientScreen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.data.GradientBuilder
import com.example.gradienter.data.models.GradientItem

@Composable
fun Gradient(
    colorRepresentation: ColorRepresentations.Representation,
    listItems: List<GradientItem>,
    onItemClick: (GradientItem) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState
    ) {
        items(listItems) { item ->
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
private fun GradientPreview() {
    Gradient(
        colorRepresentation = ColorRepresentations.Representation.HEX,
        onItemClick = {},
        listItems = GradientBuilder.build(
            listOf(
                GradientBuilder.ColorDotsParam(Color.Red, 15),
                GradientBuilder.ColorDotsParam(Color.Yellow, 15),
                GradientBuilder.ColorDotsParam(Color.Green, 15),
                GradientBuilder.ColorDotsParam(Color.Blue, 15),
            )
        )
    )
}
