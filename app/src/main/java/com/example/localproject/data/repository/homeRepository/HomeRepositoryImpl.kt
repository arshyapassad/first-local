package com.example.localproject.data.repository.homeRepository

import android.util.Log
import androidx.room.RoomDatabase
import com.example.localproject.data.db.AppDatabase
import com.example.localproject.data.modle.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val appDatabase: AppDatabase) : HomeRepository {
    override suspend fun addTask(task: Task) {
        appDatabase.taskDao().addTask(task)
    }

    override suspend fun getTask(taskId: Long): Task {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(): List<Task> = appDatabase.taskDao().getTasks()
    override suspend fun updateTask(task: Task) {
        appDatabase.taskDao().updateTask(task)
    }

    override suspend fun removeTask(task: Task) {
        appDatabase.taskDao().deleteTask(task)
    }
}