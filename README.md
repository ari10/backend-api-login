🚀 Project Overview

Backend ini adalah REST API Authentication System menggunakan Kotlin + Spring Boot dengan JWT (JSON Web Token) sebagai mekanisme autentikasi.

Project ini dirancang stateless, scalable, dan siap digunakan sebagai backend untuk aplikasi web atau mobile.

🧱 Tech Stack

Kotlin

Spring Boot

Spring Security

JWT (io.jsonwebtoken)

PostgreSQL

Hibernate / JPA

BCrypt Password Encoder

🗂 Project Structure
src/main/kotlin/com/example/backend
│
├── config
│   └── SecurityConfig.kt
│
├── controller
│   ├── AuthController.kt
│   └── UserController.kt
│
├── dto
│   ├── LoginRequest.kt
│   ├── RegisterRequest.kt
│   ├── AuthResponse.kt
│   └── UserResponse.kt
│
├── exception
│   └── GlobalExceptionHandler.kt
│
├── model
│   └── User.kt
│
├── repository
│   └── UserRepository.kt
│
├── security
│   ├── JwtAuthFilter.kt
│   └── JwtUtil.kt
│
├── service
│   └── AuthService.kt
│
└── KotlinBackendApiApplication.kt

🔑 Authentication Flow

User melakukan login

Backend memverifikasi password menggunakan BCrypt

Backend menghasilkan JWT Token

Token dikirim ke client

Endpoint terproteksi memerlukan header:

Authorization: Bearer <token>

🧪 API Endpoints
Method	Endpoint	Auth	Description
POST	/auth/register	❌	Register user
POST	/auth/login	❌	Login user & get token
GET	/users	✅	Get all users
🔐 Security Features

Stateless authentication (JWT)

Password hashing dengan BCrypt

JWT filter untuk request validation

Endpoint /auth/** dibuka tanpa token

▶️ How to Run
1. Setup Database
   CREATE DATABASE kotlin_backend_db;

2. Configure application.yml
   spring:
   datasource:
   url: jdbc:postgresql://localhost:5432/kotlin_backend_db
   username: postgres
   password: yourpassword

3. Run Application
   ./gradlew bootRun

📌 Notes

JWT tidak disimpan di database

Logout dilakukan di frontend (hapus token)

Backend tetap stateless dan scalable

✅ Project Status

✔ Authentication
✔ JWT Security
✔ PostgreSQL Integration
✔ Production-ready base