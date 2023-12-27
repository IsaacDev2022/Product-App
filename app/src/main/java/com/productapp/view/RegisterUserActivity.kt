package com.productapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.productapp.R
import com.productapp.databinding.ActivityRegisterUserBinding

class RegisterUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}