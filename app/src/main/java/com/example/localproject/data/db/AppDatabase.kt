package com.example.localproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.localproject.data.modle.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
   abstract fun taskDao(): TaskDao
}