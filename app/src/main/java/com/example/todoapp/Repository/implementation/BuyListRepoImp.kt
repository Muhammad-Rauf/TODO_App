package com.example.todoapp.Repository.implementation

import com.example.todoapp.Interface.ApiService
import com.example.todoapp.Model.BuyListing
import com.example.todoapp.Repository.abstraction.BuyListRepo
import retrofit2.Call

class BuyListRepoImp(private val apiService: ApiService) : BuyListRepo {
    override suspend fun getBuyList(): Call<BuyListing> {
     return apiService.getBuyListItem()
    }

}