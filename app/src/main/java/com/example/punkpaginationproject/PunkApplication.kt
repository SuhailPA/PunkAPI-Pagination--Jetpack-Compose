package com.example.punkpaginationproject

import android.app.Application
import com.example.punkpaginationproject.di.PunkContainer
import com.example.punkpaginationproject.di.PunkContainerImpl

class PunkApplication : Application() {
    lateinit var container: PunkContainerImpl

    override fun onCreate() {
        super.onCreate()
        container = PunkContainer(this)
    }
}

