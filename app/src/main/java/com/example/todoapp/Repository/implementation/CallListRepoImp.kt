package com.example.todoapp.Repository.implementation

import android.content.Context
import com.example.todoapp.Interface.ApiService
import com.example.todoapp.Model.CallListing
import com.example.todoapp.Repository.abstraction.CallListRepo
import retrofit2.Call
import retrofit2.Response

class CallListRepoImp(private val apiService: ApiService ,  private val context: Context) : CallListRepo {
    override suspend fun getCallList(): Call<CallListing> {
        return apiService.getCallListItem()
    }
}