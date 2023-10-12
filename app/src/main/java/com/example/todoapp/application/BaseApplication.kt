package com.example.todoapp.application

import android.app.Application
import com.example.todoapp.Injection.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(AppModules)
        }

    }

}