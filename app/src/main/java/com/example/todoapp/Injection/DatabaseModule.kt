package com.example.todoapp.Injection

import com.example.todoapp.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    single {
        AppDatabase.getInstance(androidContext()).localStoreDao()
    }


}