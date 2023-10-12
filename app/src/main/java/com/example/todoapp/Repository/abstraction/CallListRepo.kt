package com.example.todoapp.Repository.abstraction

import com.example.todoapp.Model.CallListing
import retrofit2.Call

interface CallListRepo {

    suspend fun getCallList() : Call<CallListing>
}