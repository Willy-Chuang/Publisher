package com.willy.publisher

import android.app.Application
import android.content.Context

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        TheApp.appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
    }
}