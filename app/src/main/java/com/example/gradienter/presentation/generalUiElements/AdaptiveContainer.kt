package com.example.gradienter.presentation.generalUiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AdaptiveContainer(
    modifier: Modifier = Modifier,
    isRow: Boolean = true,
    content: @Composable () -> Unit,
) {
    if (isRow) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            content()
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RowAdaptiveContainerPreview() {
    AdaptiveContainer(
        isRow = true,
    ) {
        Text("Example")
        Text("Example")
    }
}


@Preview(showBackground = true)
@Composable
private fun ColumnAdaptiveContainerPreview() {
    AdaptiveContainer(
        isRow = false,
    ) {
        Text("Example")
        Text("Example")
    }
}
