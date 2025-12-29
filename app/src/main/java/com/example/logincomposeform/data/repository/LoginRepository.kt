package com.example.logincomposeform.data.repository

// LoginRepository.kt
import com.example.logincomposeform.data.model.LoginRequest
import com.example.logincomposeform.data.model.LoginResponse
import com.example.logincomposeform.data.network.RetrofitClient
import retrofit2.Response


class LoginRepository {

    suspend fun loginUser(request: LoginRequest): Response<LoginResponse> {
        return RetrofitClient.apiService.loginUser(request)
    }
}
