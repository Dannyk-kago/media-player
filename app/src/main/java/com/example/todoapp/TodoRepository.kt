package com.example.todoapp

import androidx.annotation.WorkerThread

class TodoRepository(private val todoDao: TodoDao) {
    @WorkerThread
    suspend fun insertTodoItems(todoItems: TodoItems){
        todoDao.insertTodoItem(todoItems)
    }
}