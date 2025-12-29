package com.example.logincomposeform.data.network

import com.example.logincomposeform.data.model.LoginRequest
import com.example.logincomposeform.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("User/login")
    suspend fun loginUser(
        @Body request: LoginRequest
    ): Response<LoginResponse>


}