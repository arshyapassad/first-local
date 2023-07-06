package com.example.localproject.data.repository.homeRepository

import com.example.localproject.data.modle.Task

interface HomeRepository {
    suspend fun addTask(task: Task)

    suspend fun getTask(taskId: Long): Task

    suspend fun getTasks(): List<Task>

    suspend fun updateTask(task:Task)

    suspend fun removeTask(task: Task)
}