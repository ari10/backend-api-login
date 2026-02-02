package com.example.backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(

    @field:NotBlank(message = "Username tidak boleh kosong")
    val username: String,

    @field:Size(min = 5, message = "Password minimal 5 karakter")
    val password: String
)
