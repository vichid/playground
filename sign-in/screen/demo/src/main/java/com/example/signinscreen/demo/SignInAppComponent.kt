package com.example.signinscreen.demo

import com.example.base.di.AppScope
import com.example.base.di.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface SignInAppComponent
