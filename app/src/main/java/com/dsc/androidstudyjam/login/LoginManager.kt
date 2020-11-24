package com.dsc.androidstudyjam.login

import android.util.Patterns

class LoginManager {

    fun doLogin(email: String, password: String): LoginStatus {
        val loginStatus = LoginStatus.LoginSuccess
        if (email.isEmpty()) return LoginStatus.EmailError
        if (!isValidEmail(email)) return LoginStatus.EmailFormatNotValid
        if (password.isEmpty()) return LoginStatus.PasswordError
        return loginStatus
    }


    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    sealed class LoginStatus {
        object EmailError : LoginStatus()
        object PasswordError : LoginStatus()
        object EmailFormatNotValid : LoginStatus()
        object LoginSuccess : LoginStatus()
    }
}