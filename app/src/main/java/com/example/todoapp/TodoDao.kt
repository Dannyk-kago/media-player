package com.example.todoapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_items ORDER BY ID")
    suspend fun getTodos(): Flow<List<TodoItems>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodoItem(todo: TodoItems)

    @Query("DELETE FROM todo_items")
    suspend fun deleteAll()
}