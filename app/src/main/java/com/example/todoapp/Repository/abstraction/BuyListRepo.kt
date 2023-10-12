package com.example.todoapp.Repository.abstraction

import com.example.todoapp.Model.BuyListing
import com.example.todoapp.Model.CallListing
import retrofit2.Call

interface BuyListRepo {

    suspend fun getBuyList () : Call<BuyListing>
}