package com.example.logincomposeform.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logincomposeform.data.model.LoginRequest
import com.example.logincomposeform.data.model.LoginResponse
import com.example.logincomposeform.data.repository.LoginRepository
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

// Sealed class for login states
sealed class LoginResult {
    data class Success(val response: Response<LoginResponse>) : LoginResult()
    data class Error(val exception: String) : LoginResult()
    object Loading : LoginResult()
}

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> get() = _loginResult

    fun loginUser(request: LoginRequest) {
        viewModelScope.launch {
            _loginResult.value = LoginResult.Loading
            try {
                val response = repository.loginUser(request)
                if (response.isSuccessful) {
                    _loginResult.value = LoginResult.Success(response)
                } else {
                    // Try to extract API error message from response body
                    val errorBody = response.errorBody()?.string()
                    val errorMessage = try {
                        val json = JSONObject(errorBody ?: "")
                        json.optString("message", "Login failed.")
                    } catch (e: Exception) {
                        "Login failed."
                    }
                    _loginResult.value = LoginResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _loginResult.value = LoginResult.Error("Exception: ${e.localizedMessage}")
            }
        }
    }
}


//    fun loginUser(request: LoginRequest) {
//        viewModelScope.launch {
//            _loginResult.value = LoginResult.Loading
//            try {
//                val response = repository.loginUser(request)
//                if (response.isSuccessful) {
//                    _loginResult.value = LoginResult.Success(response)
//                } else {
//                    // API returned error (like 400/401)
//                    _loginResult.value = LoginResult.Error("Login failed: ${response.message()}")
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//                _loginResult.value = LoginResult.Error("Exception: ${e.localizedMessage}")
//            }
//        }
//    }

