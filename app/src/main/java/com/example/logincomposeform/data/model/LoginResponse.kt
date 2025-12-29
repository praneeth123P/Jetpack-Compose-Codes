package com.example.logincomposeform.data.model

// LoginResponse.kt
data class LoginResponse(
    val userId: Int,
    val name: String?,
    val email: String,
    val userName: String,
    val token: String,
    val phoneNo: Long?,
    val password: String?,
    val role: String?,
    val bank: String?,
    val accountNumber: String?,
    val pinCode: Int?,
    val branch: String?,
    val iFSCCode: String?,
    val alternativePhNo: String?,
    val aadharDetails: String?,
    val pandetails: String?,
    val gstinDetails: String?
)
