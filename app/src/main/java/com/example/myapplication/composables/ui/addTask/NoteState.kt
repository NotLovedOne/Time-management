package com.example.myapplication.composables.ui.addTask

import java.util.Date

data class NoteState(
    val id: Int? = null,
    val title: String = "",
    val date: Date = Date(),
    var priority : Int? = 1,
    var status : Boolean = true,
    var category: String = "Work"
)

