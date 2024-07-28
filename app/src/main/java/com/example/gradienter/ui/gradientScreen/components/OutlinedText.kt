package com.example.gradienter.ui.gradientScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Int,
    borderColor: Int = Color.Unspecified.toArgb(),
    textSize: Float = 16f,
    borderSize: Float = 4f,
) {
    val paint = android.graphics.Paint().apply {
        this.textSize = textSize
        isAntiAlias = true
    }
    val textWidth = paint.measureText(text)
    val textHeight = paint.fontMetrics.run { descent - ascent }

    Box(modifier = modifier
        .padding(16.dp)
        .width(textWidth.dp)
        .height(textHeight.dp)
    ) {
        Canvas(modifier = Modifier) {
            val textPaint = android.graphics.Paint().apply {
                color = textColor
                style = android.graphics.Paint.Style.FILL
                this.textSize = textSize
                isAntiAlias = true
            }
            val borderPaint = android.graphics.Paint().apply {
                color = borderColor
                style = android.graphics.Paint.Style.STROKE
                strokeWidth = borderSize
                this.textSize = textSize
                isAntiAlias = true
            }

            val xOffset = 0f
            val yOffset = textSize

            drawContext.canvas.nativeCanvas.drawText(text, xOffset, yOffset, borderPaint)
            drawContext.canvas.nativeCanvas.drawText(text, xOffset, yOffset, textPaint)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x888888,
    widthDp = 2000,
    heightDp = 400
)
@Composable
fun OutlinedTextPreview() {
    OutlinedText(
        text = "texasd adt",
        textSize = 600f,
        borderSize = 40f,
        textColor = Color.Red.toArgb(),
        borderColor = Color.Green.toArgb()
    )
}