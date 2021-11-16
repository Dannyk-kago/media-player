package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private var registerBinding:ActivityRegisterBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding?.root)

        registerBinding?.apply {
            registerBtn.setOnClickListener {
                startActivity(Intent(this@Register,Home::class.java))
            }
            alreadyHaveAccount.setOnClickListener {
                startActivity(Intent(this@Register, LoginActivity::class.java))
            }
        }

    }
}