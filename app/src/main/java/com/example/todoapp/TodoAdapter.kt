package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TaskListBinding

class TodoAdapter(private val todos:List<Todo>): RecyclerView.Adapter<TodoAdapter.MyViewModel>() {
    class MyViewModel(val item:TaskListBinding):RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val view = TaskListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewModel(view)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.item.apply {
            cbDone.isChecked = false
            tvTitle.text = todos[position].title
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}