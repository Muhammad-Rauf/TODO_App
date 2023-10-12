package com.example.todoapp.Utils.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Sealed.ApiResponse
import com.example.todoapp.Model.CallListingItem

import com.example.todoapp.Repository.abstraction.CallListRepo
import com.example.todoapp.Utils.handleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class CallListViewModel(private val callListRepo: CallListRepo) : ViewModel() {

    private val _data = MutableLiveData<ApiResponse<List<CallListingItem>>>()
    val mutableListLiveData: LiveData<ApiResponse<List<CallListingItem>>> get() = _data

    fun getCallListData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(ApiResponse.Loading)

            val apiResponse = handleResponse {
                callListRepo.getCallList().execute()
            }
            _data.postValue(apiResponse)
        }
    }
}
