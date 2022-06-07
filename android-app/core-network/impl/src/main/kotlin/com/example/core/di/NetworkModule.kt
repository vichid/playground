package com.example.core.di

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
@ContributesTo(AppScope::class)
object NetworkModule {

    @Provides
    @SingleIn(AppScope::class)
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost")
            .build()
    }
}
