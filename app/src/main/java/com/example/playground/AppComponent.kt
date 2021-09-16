package com.example.playground

import com.example.base.di.AppScope
import com.example.base.di.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent
