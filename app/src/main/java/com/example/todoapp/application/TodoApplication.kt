package com.example.todoapp.application

import android.app.Application
import com.example.todoapp.TodoRepository
import com.example.todoapp.TodoRoomDatabase

class TodoApplication: Application() {
    private val database by lazy { TodoRoomDatabase.getDatabase(this@TodoApplication) }

    val repository by lazy { TodoRepository(database.todoDao()) }
}