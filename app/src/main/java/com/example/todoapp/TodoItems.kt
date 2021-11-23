package com.example.todoapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class TodoItems(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "isChecked") val isChecked: Boolean,
    @ColumnInfo(name = "todo") val todo: String
)
