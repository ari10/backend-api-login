package com.example.backend.dto

import jakarta.validation.constraints.NotBlank

data class LoginRequest(

    @field:NotBlank(message = "Username wajib diisi")
    val username: String,

    @field:NotBlank(message = "Password wajib diisi")
    val password: String
)
