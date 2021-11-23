package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.text.TextUtils
import android.util.Log

import android.view.View
import android.widget.Toast

import androidx.activity.viewModels

import com.example.todoapp.application.TodoApplication
import com.example.todoapp.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {
    private lateinit var homeBinding:ActivityHomeBinding

    private  val mTodoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        /*---
       val todoList = mutableListOf(
            Todo(false,"Follow androidDevs"),
            Todo(true,"learn about RecycleView"),
            Todo(true,"Feed my cat"),
            Todo(false,"Ask my Crush out"),
            Todo(true,"Take a shower"),
            Todo(false,"Go for a walk")
       )
        val adapter = TodoAdapter(todoList)
        homeBinding.todoItemsList.adapter = adapter

        homeBinding.btnAddTodo.setOnClickListener {
            val title = homeBinding.edTodo.text.toString()
            val todo = Todo(false,title)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
            clearData()
        }

    }
    private fun clearData(){
        homeBinding.edTodo.setText("")
    }

     */

        homeBinding.btnAddTodo.setOnClickListener {
            val title = homeBinding.edTodo.text.toString().trim()
            if (TextUtils.isEmpty(edTodo.toString())){
                Toast.makeText(this@Home,
                    "Cannot be Empty",Toast.LENGTH_SHORT).show()
            }else{
                val todoItemsDetails: TodoItems = TodoItems(
                   0,
                    false,
                    title
                )
                mTodoViewModel.insert(todoItemsDetails)

                Toast.makeText(
                    this@Home,
                    "You successfully added your todo",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("Insertion", "Success")
                finish()
            }
        }


    }
}