package com.example.logincomposeform

import android.content.Context
import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.example.logincomposeform.data.model.LoginRequest
import com.example.logincomposeform.viewmodel.LoginResult
import com.example.logincomposeform.viewmodel.LoginViewModel


@Composable
    fun LoginScreen(
        viewModel: LoginViewModel,
        onNavigateHome: () -> Unit,
        onSignUpClick: () -> Unit,
        onForgotPasswordClick: () -> Unit
    ) {
        val context = LocalContext.current
        val sharedPrefs = context.getSharedPreferences("login", Context.MODE_PRIVATE)

        var email by remember { mutableStateOf(sharedPrefs.getString("email", "") ?: "") }
        var password by remember { mutableStateOf(sharedPrefs.getString("password", "") ?: "") }
        var rememberMe by remember { mutableStateOf(sharedPrefs.getBoolean("rememberMe", false)) }

        var emailError by remember { mutableStateOf("") }
        var passwordError by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        val loginResult by viewModel.loginResult.observeAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Waymaart", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(24.dp))
            Card(
                //elevation = 8.dp,
                modifier = Modifier.padding(20.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Sign In", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            emailError = ""
                        },
                        label = { Text("User Name") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = emailError.isNotEmpty(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    if (emailError.isNotEmpty()) {
                        Text(emailError, color = MaterialTheme.colorScheme.error)
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            passwordError = ""
                        },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation =
                        if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible)
                                        Icons.Filled.Visibility
                                    else Icons.Filled.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }
                    )
                    if (passwordError.isNotEmpty()) {
                        Text(passwordError, color = MaterialTheme.colorScheme.error)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it }
                        )
                        Text("Remember Me")
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(onClick = onForgotPasswordClick) {
                            Text("Forgot Password?")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            if (validate(
                                    email,
                                    password,
                                    onEmailError = { emailError = it },
                                    onPasswordError = { passwordError = it })
                            ) {

                                if (rememberMe) {
                                    sharedPrefs.edit().apply {
                                        putString("email", email)
                                        putString("password", password)
                                        putBoolean("rememberMe", true)
                                        apply()
                                    }
                                } else {
                                    sharedPrefs.edit().clear().apply()
                                }

                                viewModel.loginUser(LoginRequest(email, password))
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("SIGN IN")
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(onClick = onSignUpClick) {
                        Text("I don’t have an account? Sign Up")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            when (loginResult) {
                is LoginResult.Loading -> {
                    CircularProgressIndicator()
                }

                is LoginResult.Success -> {
                    LaunchedEffect(Unit) {
                        val user = (loginResult as LoginResult.Success).response.body()
                        user?.let {
                            sharedPrefs.edit().apply {
                                putInt("user_id", it.userId)
                                putString("AUTH_TOKEN", it.token)
                                putString("username", it.userName)
                                putString("email", it.email)
                                putString("user_role", it.role)
                                putBoolean("isLoggedIn", true)
                                apply()
                            }
                        }
                        onNavigateHome()
                    }
                }

                is LoginResult.Error -> {
                    Text(
                        text = (loginResult as LoginResult.Error).exception,
                        color = MaterialTheme.colorScheme.error
                    )
                }

                else -> {}
            }
        }
    }

    private fun validate(
        email: String,
        password: String,
        onEmailError: (String) -> Unit,
        onPasswordError: (String) -> Unit
    ): Boolean {
        var valid = true

        if (email.isEmpty()) {
            onEmailError("Please enter email")
            valid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            onEmailError("Invalid email format")
            valid = false
        }

        if (password.isEmpty()) {
            onPasswordError("Please enter password")
            valid = false
        }

        return valid
    }

