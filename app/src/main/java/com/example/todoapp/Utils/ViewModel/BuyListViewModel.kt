package com.example.todoapp.Utils.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Sealed.ApiResponse
import com.example.todoapp.Model.BuyListingItem
import com.example.todoapp.Repository.abstraction.BuyListRepo
import com.example.todoapp.Utils.handleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class BuyListViewModel (private  val buyListRepo: BuyListRepo) : ViewModel() {

    private val _data = MutableLiveData<ApiResponse<List<BuyListingItem>>>()
    val mutableListLiveData: LiveData<ApiResponse<List<BuyListingItem>>> get() = _data

    fun getBuyListData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(ApiResponse.Loading)
            val apiResponse = handleResponse {
                buyListRepo.getBuyList().execute()
            }
            _data.postValue(apiResponse)
        }
    }

}