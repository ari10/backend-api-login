package com.example.backend.controller

import com.example.backend.dto.*
import com.example.backend.service.AuthService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = ["http://localhost:5173"])
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): AuthResponse {
        return authService.login(request)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): AuthResponse {
        return authService.register(request)
    }
}
