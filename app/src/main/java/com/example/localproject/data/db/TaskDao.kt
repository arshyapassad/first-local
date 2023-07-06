package com.example.localproject.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.localproject.data.modle.Task

@Dao
interface TaskDao {
    @Insert(onConflict = REPLACE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tbl_task")
    suspend fun getTasks():List<Task>

    @Query("SELECT * FROM tbl_task WHERE id=:id")
    suspend fun getTask(id:Long): Task
}