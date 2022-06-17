package com.example.androidapp.featurescreentopb.impl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.core.di.DaggerComponentOwner
import com.example.core.di.utils.bindings
import com.example.logger.api.Logger
import javax.inject.Inject

class TopBViewModel(application: Application) :
    AndroidViewModel(application), DaggerComponentOwner {

    override val daggerComponents =
        listOf(application.bindings<TopBSubComponent.ParentBindings>().factory().create())

    @Inject
    lateinit var logger: Logger

    init {
        bindings<TopBBindings>().inject(this)
        logger.d(message = "Top B injected")
    }
}
