package com.example.myapplication.db.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class NoteEntity(
    @PrimaryKey val id: Int?,
    var title: String,
    var date: Date,
    var priority: Int?,
    var status: Boolean,
    var category: String
)