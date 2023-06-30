package com.example.localproject.data.repository.homeRepository

import android.util.Log
import androidx.room.RoomDatabase
import com.example.localproject.data.db.AppDatabase
import com.example.localproject.data.modle.Task
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(val appDatabase: AppDatabase):HomeRepository {
    override fun addTask(task: Task) {
//        var count=0
//        while (true){
//            count++
//            Log.i("testThread","$count")
//        }
        appDatabase.taskDao().addTask(task)
    }

    override fun getTask(taskId: Long): Task {
        TODO("Not yet implemented")
    }

    override fun getTasks(): List<Task> = appDatabase.taskDao().getTasks()
    override fun updateTask(task: Task) {
        appDatabase.taskDao().updateTask(task)
    }

    override fun removeTask(task: Task) {
        appDatabase.taskDao().deleteTask(task)
    }
}