package com.productapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.productapp.R
import com.productapp.databinding.ActivityFirstScreenBinding
import com.productapp.viewModel.LoginViewModel

class FirstScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstScreenBinding
    // private val preferences = getSharedPreferences("loginSharedScreen", Context.MODE_PRIVATE)

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setContentView(binding.root)

        viewModel.verifyLoggedUser()
        observeEvents()

        /* val firstTime = preferences.getString("firstScreen", "")
        if (firstTime.equals("Yes")) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            preferences.edit().putString("firstScreen", "Yes").apply()
        } */

        binding.btnToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
        }
        binding.btnToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterUserActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
        }
    }

    private fun observeEvents() {
        viewModel.login.observe(this) {
            if (it.status()) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(applicationContext, it.message(), Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.loggedUser.observe(this) {
            if (it) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
        }
    }
}