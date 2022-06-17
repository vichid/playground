package com.example.androidapp.featurescreentopb.impl

import com.example.core.di.DaggerComponent
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(TopBScope::class)
interface TopBBindings : DaggerComponent {
    fun inject(viewModel: TopBViewModel)
}
