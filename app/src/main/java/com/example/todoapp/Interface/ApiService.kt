package com.example.todoapp.Interface

import com.example.todoapp.Model.BuyListing
import com.example.todoapp.Model.CallListing
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // https://my-json-server.typicode.com/imkhan334/demo-1/call
    @GET("imkhan334/demo-1/call")
    fun getCallListItem(): Call<CallListing>

    @GET("imkhan334/demo-1/buy")
    fun getBuyListItem(): Call<BuyListing>

}