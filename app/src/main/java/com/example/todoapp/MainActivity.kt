package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var activityMainBinding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)

        activityMainBinding?.apply {
            getStartedButton.setOnClickListener{
                val nextActivity = Intent(this@MainActivity,Register::class.java)
                startActivity(nextActivity)
            }
        }

    }
}