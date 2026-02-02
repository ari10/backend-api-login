🚀 Kotlin Backend API – JWT Authentication

Backend API menggunakan Kotlin + Spring Boot yang menerapkan JWT Authentication, PostgreSQL, dan Clean Architecture.
Project ini dibuat sebagai latihan fundamental backend Kotlin sekaligus portfolio project.

✨ Features

✅ User Register & Login

🔐 JWT Authentication (Stateless)

🛡️ Protected Endpoint (Authorization Header)

🔑 Password Encryption (BCrypt)

🧱 Clean Architecture (Controller / Service / Repository)

⚠️ Global Exception Handling

🗄️ PostgreSQL Integration

📦 REST API (JSON)

🧱 Project Structure
com.example.backend
├── config
│   └── SecurityConfig.kt
├── controller
│   ├── AuthController.kt
│   └── UserController.kt
├── dto
│   ├── ApiResponse.kt
│   ├── AuthResponse.kt
│   ├── LoginRequest.kt
│   ├── RegisterRequest.kt
│   └── UserResponse.kt
├── exception
│   └── GlobalExceptionHandler.kt
├── model
│   └── User.kt
├── repository
│   └── UserRepository.kt
├── security
│   ├── JwtAuthFilter.kt
│   └── JwtUtil.kt
├── service
│   └── AuthService.kt
└── KotlinBackendApiApplication.kt

🔍 Penjelasan Singkat

controller → REST endpoint

service → business logic

repository → database access

model → entity database

dto → request & response API

security → JWT & filter

exception → centralized error handling

🔐 Authentication Flow (JWT)

User melakukan register

Password disimpan dalam bentuk hash (BCrypt)

User login

Server mengembalikan JWT token

Token dikirim via header:

Authorization: Bearer <JWT_TOKEN>


Endpoint protected hanya bisa diakses dengan token valid

📡 API Endpoints
🔓 Public Endpoints
Register
POST /auth/register

{
"username": "ari",
"password": "12345"
}

Login
POST /auth/login

{
"username": "ari",
"password": "12345"
}


Response:

{
"success": true,
"message": "Login berhasil",
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

🔒 Protected Endpoint
Get All Users
GET /users


Header:

Authorization: Bearer <JWT_TOKEN>


Response:

[
{
"id": 1,
"username": "ari"
},
{
"id": 2,
"username": "ari2"
}
]

🗄️ Database Configuration

PostgreSQL

spring:
datasource:
url: jdbc:postgresql://localhost:5432/kotlin_backend_db
username: postgres
password: your_password
jpa:
hibernate:
ddl-auto: update
show-sql: true

▶️ Running the Project
1️⃣ Clone Repository
git clone https://github.com/ari10/backend-api-login.git
cd kotlin-backend-api

2️⃣ Run Application
./gradlew bootRun


atau langsung dari IntelliJ:

Run → KotlinBackendApiApplication


Server akan berjalan di:

http://localhost:8080

🧪 Testing

Gunakan Postman atau Insomnia:

Register user

Login → ambil token

Gunakan token untuk akses /users