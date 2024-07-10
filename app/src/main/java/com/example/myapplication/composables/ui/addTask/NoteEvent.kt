package com.example.myapplication.composables.ui.addTask

import java.util.Date

sealed interface NoteEvent {
    data class TitleChange(val value: String): NoteEvent
    data class DateChange(val value: Date): NoteEvent
    data class PriorityChange(val value: Int): NoteEvent
    data class StatusChange(val value: Boolean): NoteEvent
    data class CategoryChange(val value: String): NoteEvent
    object Save : NoteEvent
    object NavigateBack : NoteEvent
    object DeleteNote : NoteEvent
}