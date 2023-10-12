package com.example.todoapp.Injection

import com.example.todoapp.Utils.ViewModel.BuyListViewModel
import com.example.todoapp.Utils.ViewModel.CallListViewModel
import com.example.todoapp.Utils.ViewModel.SellListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules= module {
    viewModel {
        CallListViewModel(get())
    }

    viewModel {
        SellListViewModel(get())
    }

    viewModel {
        BuyListViewModel(get())
    }

}