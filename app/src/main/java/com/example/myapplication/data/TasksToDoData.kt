package com.example.myapplication.data

import androidx.compose.ui.graphics.Color

data class TasksToDoData(
    val check: Boolean, val categoryColor: Color, val title: String, val time: String, val priority: String
)