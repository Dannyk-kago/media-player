package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository): ViewModel() {
    fun insert(todo: TodoItems) = viewModelScope.launch {
        repository.insertTodoItems(todo)
    }
}

class TodoViewModelFactory(private val repository: TodoRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown viewModel class")
    }
}