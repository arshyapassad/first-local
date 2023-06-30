package com.example.localproject.data.repository.homeRepository

import com.example.localproject.data.modle.Task

interface HomeRepository {
    fun addTask(task: Task)

    fun getTask(taskId: Long): Task

    fun getTasks(): List<Task>
}