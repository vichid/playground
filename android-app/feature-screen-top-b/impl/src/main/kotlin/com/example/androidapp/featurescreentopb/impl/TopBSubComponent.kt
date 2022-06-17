package com.example.androidapp.featurescreentopb.impl

import com.example.core.di.AppScope
import com.example.core.di.DaggerComponent
import com.example.core.di.SingleIn
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo

@SingleIn(TopBScope::class)
@ContributesSubcomponent(scope = TopBScope::class, parentScope = AppScope::class)
interface TopBSubComponent : DaggerComponent {

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): TopBSubComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentBindings : DaggerComponent {
        fun factory(): Factory
    }
}
