package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoItems::class], version = 1)
abstract class TodoRoomDatabase: RoomDatabase(){

    abstract fun todoDao(): TodoDao

    companion object{
        @Volatile
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(context: Context): TodoRoomDatabase {
            //if the INSTANCE is not null, then return it
            //if it is ,then create the datadase
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoRoomDatabase::class.java,
                    "todo_items"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }

}