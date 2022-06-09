package com.example.list.screen.impl

import androidx.lifecycle.ViewModel
import com.example.core.di.AppScope
import com.example.core.di.ContributesViewModel
import com.example.core.di.SingleIn
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesViewModel(AppScope::class)
class ListViewModel
@Inject constructor() : ViewModel()
