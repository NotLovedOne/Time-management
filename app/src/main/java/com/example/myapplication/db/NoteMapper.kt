package com.example.myapplication.db

import com.example.myapplication.db.domain.model.Note
import com.example.myapplication.db.local.entity.NoteEntity

fun NoteEntity.asExternalModel(): Note = Note(
    id, title, date,priority,status,category
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id, title,date,priority,status,category
)