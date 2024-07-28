package com.example.gradienter.presentation.screens.editGradientScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradienter.R
import com.example.gradienter.domain.models.EditGradientItem
import com.example.gradienter.presentation.theme.mainTheme.MainTheme
import com.example.todoapp.presentation.themes.AppTheme
import com.example.todoapp.presentation.themes.themeColors

@Composable
fun EditGradientList(
    modifier: Modifier = Modifier,
    itemsList: List<EditGradientItem>,
    onAddNewElementClick: () -> Unit,
    onColorChangeClick: (String, Color) -> Unit,
    onDistanceChange: (String, Int) -> Unit,
    onDeleteItem: (EditGradientItem) -> Unit,
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = lazyListState
    ) {
        items(itemsList) { item ->
            EditGradientElement(
                modifier = Modifier
                    .padding(8.dp),
                color = item.color,
                distance = item.distanceToNextColor,
                onColorChangeClick = { color ->
                    onColorChangeClick(item.id, color)
                },
                onDistanceChange = { distance ->
                    onDistanceChange(item.id, distance)
                },
                onDeleteClick = {
                    onDeleteItem(item)
                }
            )
        }
        item {
            Text(
                text = stringResource(R.string.newGradientElement),
                textAlign = TextAlign.Center,
                color = themeColors.labelSecondary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAddNewElementClick() }
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun EditGradientListPreview() {
    AppTheme(theme = MainTheme) {
        EditGradientList(
            onAddNewElementClick = {},
            onColorChangeClick = { _, _ -> },
            onDistanceChange = { _, _ -> },
            onDeleteItem = {},
            itemsList = listOf(
                EditGradientItem(color = Color.Red, distanceToNextColor = 64),
                EditGradientItem(color = Color.Yellow, distanceToNextColor = 64),
                EditGradientItem(color = Color.Green, distanceToNextColor = 64),
                EditGradientItem(color = Color.Blue, distanceToNextColor = 64),
            )
        )
    }
}
