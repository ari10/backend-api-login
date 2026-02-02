package com.example.backend.dto

data class AuthResponse(
    val success: Boolean,
    val message: String,
    val token: String? = null
)
