package com.example.androidapp.corethreading.fakes

import com.example.core.di.AppScope
import com.example.core.di.SingleIn
import com.example.corethreading.api.AppDispatchers
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
data class FakeAppDispatchersImpl @Inject constructor(
    override val io: CoroutineDispatcher = Dispatchers.Unconfined,
    override val computation: CoroutineDispatcher = Dispatchers.Unconfined,
    override val main: CoroutineDispatcher = Dispatchers.Unconfined
) : AppDispatchers
