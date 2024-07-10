package com.example.myapplication.db.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.db.DateConverter
import com.example.myapplication.db.local.dao.NoteDao
import com.example.myapplication.db.local.entity.NoteEntity


@Database(
    version = 1,
    entities = [NoteEntity::class]
)
@TypeConverters(DateConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract val dao: NoteDao

    companion object {
        const val name = "note_db"
    }
}