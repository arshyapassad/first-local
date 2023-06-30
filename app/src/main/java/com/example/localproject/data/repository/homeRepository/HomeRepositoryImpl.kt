package com.example.localproject.data.repository.homeRepository

import androidx.room.RoomDatabase
import com.example.localproject.data.db.AppDatabase
import com.example.localproject.data.modle.Task
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val appDatabase: AppDatabase):HomeRepository {
    override fun addTask(task: Task) {
        appDatabase.taskDao().addTask(task)
    }

    override fun getTask(taskId: Long): Task {
        TODO("Not yet implemented")
    }

    override fun getTasks(): List<Task> {
        TODO("Not yet implemented")
    }
}