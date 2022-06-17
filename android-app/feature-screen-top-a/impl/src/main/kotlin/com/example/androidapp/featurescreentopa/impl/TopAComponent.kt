package com.example.androidapp.featurescreentopa.impl

import com.example.core.di.AppScope
import com.example.core.di.DaggerComponent
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface TopAComponent : DaggerComponent {
    fun inject(viewModel: TopAViewModel)
}
