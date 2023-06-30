package com.example.localproject.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.localproject.data.modle.Task

@Dao
interface TaskDao {
    @Insert
    fun addTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM tbl_task")
    fun getTasks():List<Task>

    @Query("SELECT * FROM tbl_task WHERE id=:id")
    fun getTask(id:Long): Task
}