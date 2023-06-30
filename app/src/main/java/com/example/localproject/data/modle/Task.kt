package com.example.localproject.data.modle

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "NameTask")
    val nameTask: String,
    val isChecked: Boolean
)
