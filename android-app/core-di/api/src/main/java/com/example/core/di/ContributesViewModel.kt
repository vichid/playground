package com.example.core.di

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class ContributesViewModel(val scope: KClass<*>)
