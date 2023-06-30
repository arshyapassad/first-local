package com.example.localproject.data.modle

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    @ColumnInfo(name = "NameTask")
    var nameTask: String,
    var isChecked: Boolean
):Parcelable
