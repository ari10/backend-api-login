package com.example.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBackendApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinBackendApiApplication>(*args)
}
