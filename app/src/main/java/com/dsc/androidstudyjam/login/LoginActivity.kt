package com.dsc.androidstudyjam.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dsc.androidstudyjam.R
import com.dsc.androidstudyjam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginManager = LoginManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            doLogin(username, password)
        }
    }

    private fun doLogin(email: String, password: String) {
        val loginStatus = loginManager.doLogin(email, password)
        when (loginStatus) {
            LoginManager.LoginStatus.LoginSuccess -> {
                Toast.makeText(this, "Go to Home screen", Toast.LENGTH_LONG).show()
            }
            LoginManager.LoginStatus.EmailError -> binding.etEmail.error =
                getString(R.string.email_error)
            LoginManager.LoginStatus.PasswordError -> binding.etPassword.error =
                getString(R.string.password_error)
            LoginManager.LoginStatus.EmailFormatNotValid -> binding.etEmail.error =
                getString(R.string.email_format_error)
        }
    }
}