package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var activityLoginBinding:ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding?.root)

        activityLoginBinding?.apply {
            loginBtn.setOnClickListener {
                startActivity(Intent(this@LoginActivity,Home::class.java))
            }
            dontHaveAccount.setOnClickListener {
                startActivity(Intent(this@LoginActivity, Register::class.java))
            }
        }
    }
}