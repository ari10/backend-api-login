package com.example.backend.service

import com.example.backend.dto.LoginRequest
import com.example.backend.dto.RegisterRequest
import com.example.backend.dto.AuthResponse
import com.example.backend.model.User
import com.example.backend.repository.UserRepository
import com.example.backend.security.JwtUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun register(request: RegisterRequest): AuthResponse {
        if (userRepository.findByUsername(request.username) != null) {
            return AuthResponse(false, "Username sudah digunakan")
        }

        val user = User(
            username = request.username,
            password = passwordEncoder.encode(request.password)
        )

        userRepository.save(user)

        return AuthResponse(
            success = true,
            message = "Register berhasil"
        )
    }

    fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByUsername(request.username)
            ?: return AuthResponse(false, "User tidak ditemukan")

        if (!passwordEncoder.matches(request.password, user.password)) {
            return AuthResponse(false, "Password salah")
        }

        // 🔐 INI JWT-NYA
        val token = jwtUtil.generateToken(user.username)

        return AuthResponse(
            success = true,
            message = "Login berhasil",
            token = token
        )
    }
}
