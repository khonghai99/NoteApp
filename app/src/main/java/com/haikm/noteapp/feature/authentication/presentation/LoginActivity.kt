package com.haikm.noteapp.feature.authentication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.haikm.noteapp.R
import com.haikm.noteapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace<SignInFragment>(containerViewId = R.id.fragmentContainer, tag = "SignInFragment")
            }
        }
    }
}