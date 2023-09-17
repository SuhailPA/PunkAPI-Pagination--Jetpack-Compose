package com.example.punkpaginationproject

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.punkpaginationproject.ui.PunkViewModel

object PunkViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            val application =
                this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PunkApplication
            PunkViewModel(pager = application.container.pager)
        }
    }
}