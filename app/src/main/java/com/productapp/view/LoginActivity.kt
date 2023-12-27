package com.productapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.productapp.R
import com.productapp.databinding.ActivityLoginBinding
import com.productapp.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.tvRegister.setOnClickListener(this)

        viewModel.verifyLoggedUser()
        observeEvents()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_login) {
            handleLogin()
        } else if (v.id == R.id.tv_register) {
            startActivity(Intent(applicationContext, RegisterUserActivity::class.java))
        }
    }

    private fun observeEvents() {
        viewModel.login.observe(this) {
            if (it.status()) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                onResume()
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

    private fun handleLogin() {
        val username = binding.edtUserName.text.toString()
        val password = binding.edtPassword.text.toString()

        viewModel.doLogin(username, password)
    }
}