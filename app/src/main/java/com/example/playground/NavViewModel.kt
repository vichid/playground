package com.example.playground

import androidx.lifecycle.ViewModel
import com.example.navigation.api.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class NavViewModel @Inject constructor(navigator: Navigator) :
    ViewModel(),
    Navigator by navigator
