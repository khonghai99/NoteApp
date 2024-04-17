package com.haikm.noteapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.haikm.noteapp.databinding.ActivitySplashBinding
import com.haikm.noteapp.feature.authentication.presentation.LoginActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(2_000)
            navigateLoginScreen()
        }
    }

    private fun navigateLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}