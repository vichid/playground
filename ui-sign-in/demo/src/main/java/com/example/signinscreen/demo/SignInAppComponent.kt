package com.example.signinscreen.demo

import com.example.base.di.AppScope
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Singleton

@Singleton
@MergeComponent(AppScope::class)
interface SignInAppComponent
