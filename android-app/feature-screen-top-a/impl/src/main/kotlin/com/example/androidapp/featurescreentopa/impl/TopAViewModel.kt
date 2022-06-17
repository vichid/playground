package com.example.androidapp.featurescreentopa.impl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.core.di.utils.bindings
import com.example.logger.api.Logger
import javax.inject.Inject

class TopAViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var logger: Logger

    init {
        bindings<TopAComponent>().inject(this)
        logger.d(message = "Top A injected")
    }
}
