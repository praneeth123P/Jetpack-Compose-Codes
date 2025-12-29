package com.example.logincomposeform

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.logincomposeform.data.repository.LoginRepository
import com.example.logincomposeform.viewmodel.LoginViewModel
import com.example.logincomposeform.viewmodel.LoginViewModelFactory

class LoginActivity : ComponentActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel initialization
        val repository = LoginRepository()
        val factory = LoginViewModelFactory(repository)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        setContent {
            LoginScreen(
                viewModel = loginViewModel,
                onNavigateHome = { navigateToHome() },
                onSignUpClick = { navigateToRegister() },
                onForgotPasswordClick = { navigateToForgotPassword() }
            )
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun navigateToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private fun navigateToForgotPassword() {
        //startActivity(Intent(this, ForgotPasswordActivity::class.java))
    }
}
