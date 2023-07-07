package com.example.localproject.data.repository.homeRepository

import com.example.localproject.data.modle.Task
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun addTask(task: Task)

    suspend fun getTask(taskId: Long): Task

    suspend fun getTasks(): Flow<List<Task>>

    suspend fun updateTask(task:Task)

    suspend fun removeTask(task: Task)
}