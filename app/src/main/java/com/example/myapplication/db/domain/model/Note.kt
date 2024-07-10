package com.example.myapplication.db.domain.model

import java.util.Date


data class Note(
    var id: Int?,
    var title: String,
    var date: Date,
    var priority: Int?,
    var status: Boolean,
    var category: String
)