package com.example.todoapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.Adapter.BuyListAdapter
import com.example.todoapp.Sealed.ApiResponse
import com.example.todoapp.Model.BuyListingItem
import com.example.todoapp.Utils.ProgressDialogUtil
import com.example.todoapp.Utils.isOnline
import com.example.todoapp.Utils.showToast
import com.example.todoapp.Utils.ViewModel.BuyListViewModel
import com.example.todoapp.Utils.ViewModel.SellListViewModel
import com.example.todoapp.databinding.ActivityBuyListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class BuyListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuyListBinding
    private val buyListViewModel  : BuyListViewModel by viewModel()
    private val sellListViewModel : SellListViewModel by viewModel()
    private val adapter by lazy {
        BuyListAdapter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buyListRecyclerViewID.adapter = adapter

        dataObserver()
        getData()


    }


    private fun dataObserver() {
        buyListViewModel.mutableListLiveData.observe(this) { response ->
            when (response) {
                is ApiResponse.Loading -> {
                    ProgressDialogUtil.showProgressDialog(this)
                }

                is ApiResponse.Success -> {
                    ProgressDialogUtil.dismissProgressDialog()
                    if (response.data.isNotEmpty()) {
                        adapter.submitList(response.data.toMutableList())
                        saveDataToDB(response.data.toMutableList())

                    } else {
                        showToast("Data is not available")
                    }
                }

                is ApiResponse.Failure -> {
                    ProgressDialogUtil.dismissProgressDialog()
                    showToast(response.error)
                }
            }
        }
    }

    private fun saveDataToDB(toMutableList: MutableList<BuyListingItem>) {

        lifecycleScope.launch (Dispatchers.IO){
            sellListViewModel.saveData(toMutableList)
        }

        CoroutineScope(Dispatchers.IO).launch{

        }
    }


    private fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (isOnline()) {
                buyListViewModel.getBuyListData()
            } else {
                withContext(Dispatchers.Main) {
                    showToast("You are not online")
                }
            }
        }
    }
}