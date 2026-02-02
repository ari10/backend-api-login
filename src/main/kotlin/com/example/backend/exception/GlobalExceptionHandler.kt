package com.example.backend.exception

import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): Map<String, Any> {
        val error = ex.bindingResult.fieldErrors.first().defaultMessage
        return mapOf(
            "success" to false,
            "message" to error!!
        )
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntime(ex: RuntimeException): Map<String, Any> {
        return mapOf(
            "success" to false,
            "message" to ex.message!!
        )
    }
}
