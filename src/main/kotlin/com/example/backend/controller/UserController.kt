package com.example.backend.controller

import com.example.backend.dto.UserResponse
import com.example.backend.model.User
import com.example.backend.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userRepository: UserRepository
) {

    @GetMapping
    fun getAllUsers(): List<UserResponse> {
        return userRepository.findAll().map {
            UserResponse(
                id = it.id!!,
                username = it.username
            )
        }
    }
}
