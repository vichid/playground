package com.example.corethreading.impl

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.corethreading.api.AppDispatchers
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
data class AppDispatchersImpl @Inject constructor(
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val computation: CoroutineDispatcher = Dispatchers.Default,
    override val main: CoroutineDispatcher = Dispatchers.Main
) : AppDispatchers
