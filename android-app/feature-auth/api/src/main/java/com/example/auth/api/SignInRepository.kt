package com.example.auth.api

interface SignInRepository {

    suspend fun signIn(email: String, password: String): UserProfile
}

class UserProfile(
    val userId: String,
    val name: String,
    val profilePicture: String
)

@JvmInline
value class Username(val value: String)

@JvmInline
value class Password(val value: String)
