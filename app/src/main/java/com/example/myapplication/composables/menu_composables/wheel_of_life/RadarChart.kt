package com.example.myapplication.composables.menu_composables.wheel_of_life

import android.graphics.Color.BLACK
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.LifeAspect
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
@Composable
fun RadarChart(
    lifeAspects: List<LifeAspect>,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radius = min(centerX, centerY) * 0.8f

        drawCircle(
            color = Color.Gray,
            center = Offset(centerX, centerY),
            radius = radius*0.8f,
            style = Stroke(width = 2.dp.toPx())
        )

        val numSides = lifeAspects.size
        val angleStep = 360 / numSides.toFloat()
        val outerPoints = (0 until numSides).map { angle ->
            val angleInRadians = Math.toRadians(angleStep * angle.toDouble())
            val outerX = centerX + 0.8f*radius * cos(angleInRadians).toFloat()
            val outerY = centerY + 0.8f*radius * sin(angleInRadians).toFloat()
            drawLine(
                color = Color.Gray,
                start = Offset(centerX, centerY),
                end = Offset(outerX, outerY),
                strokeWidth = 2.dp.toPx()
            )
            Offset(outerX, outerY)
        }

        val dataPoints = lifeAspects.mapIndexed { index, aspect ->
            val angleInRadians = Math.toRadians(angleStep * index.toDouble())
            val scaledValue = aspect.score * radius * 0.8f
            Offset(
                x = centerX + scaledValue * cos(angleInRadians).toFloat(),
                y = centerY + scaledValue * sin(angleInRadians).toFloat()
            )



        }
        drawPath(
            path = Path().apply {
                dataPoints.forEachIndexed { index, point ->
                    if (index == 0) {
                        moveTo(point.x, point.y)
                    } else {
                        lineTo(point.x, point.y)
                    }
                }
                close()
            },
            color = Color.Blue,
            style = Stroke(width = 2.dp.toPx())
        )

        for ((index, aspectName) in lifeAspects.withIndex()) {
            val angleInRadians = Math.toRadians(angleStep * index.toDouble())
            val labelOffset = 20.dp.toPx()
            val labelX = centerX + (radius + labelOffset) * cos(angleInRadians).toFloat()
            val labelY = centerY + (radius + labelOffset) * sin(angleInRadians).toFloat()

            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    aspectName.name.toString(),
                    labelX,
                    labelY,
                    android.graphics.Paint().apply {
                        color = BLACK
                        textSize = 16.sp.toPx()
                        textAlign = android.graphics.Paint.Align.CENTER
                    }
                )
            }
        }
    }
}
