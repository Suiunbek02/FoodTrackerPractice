package com.suiunbek.foodtrackerpractice.data.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.suiunbek.foodtrackerpractice.data.local.db.room.dao.NoteDao
import com.suiunbek.foodtrackerpractice.models.NoteModel

@Database(entities = [NoteModel::class], version = 3)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}