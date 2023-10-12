package com.example.todoapp.Injection

import com.example.todoapp.Repository.abstraction.BuyListRepo
import com.example.todoapp.Repository.abstraction.CallListRepo
import com.example.todoapp.Repository.abstraction.SellListRepo
import com.example.todoapp.Repository.implementation.BuyListRepoImp
import com.example.todoapp.Repository.implementation.CallListRepoImp
import com.example.todoapp.Repository.implementation.SellListRepoImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule= module {
    single <CallListRepo>{ CallListRepoImp(get(), androidContext())  }
    single <BuyListRepo>{ BuyListRepoImp(get())  }
    single <SellListRepo>{ SellListRepoImp( androidContext() , get())  }

    //single <SellListRepo>{ SellListRepoImp( androidContext())  }

}