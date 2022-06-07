package com.example.auth.impl

import com.example.core.di.AppScope
import com.example.core.di.ContributesApi
import retrofit2.http.GET

@ContributesApi(AppScope::class)
interface SignInApi {
    @GET("/")
    suspend fun login(): Boolean
}
