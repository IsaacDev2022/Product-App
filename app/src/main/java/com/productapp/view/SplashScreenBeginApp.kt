package com.productapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.productapp.R
import com.productapp.databinding.ActivitySplashScreenBeginAppBinding
import com.productapp.viewModel.LoginViewModel

class SplashScreenBeginApp : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBeginAppBinding
    private val SPLACH_TIME: Long = 2000

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBeginAppBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this, FirstScreenActivity::class.java))
            finish()
        }, SPLACH_TIME)
    }
}