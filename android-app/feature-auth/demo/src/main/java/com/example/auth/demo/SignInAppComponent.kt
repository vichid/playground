package com.example.auth.demo

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface SignInAppComponent
