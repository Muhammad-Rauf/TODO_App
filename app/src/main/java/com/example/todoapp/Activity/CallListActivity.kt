package com.example.todoapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.Adapter.CallListAdapter
import com.example.todoapp.Sealed.ApiResponse
import com.example.todoapp.Utils.ProgressDialogUtil
import com.example.todoapp.Utils.isOnline
import com.example.todoapp.Utils.showToast
import com.example.todoapp.Utils.ViewModel.CallListViewModel
import com.example.todoapp.databinding.ActivityCallListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class CallListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCallListBinding
    private val callingListViewModel: CallListViewModel by viewModel()
    private val adapter by lazy {
        CallListAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.callListRecyclerView.adapter = adapter
        dataObserver()
        getData()
    }


    private fun dataObserver() {
        callingListViewModel.mutableListLiveData.observe(this) { response ->
            when (response) {
                is ApiResponse.Loading -> {
                    ProgressDialogUtil.showProgressDialog(this)
                }
                is ApiResponse.Success -> {
                    ProgressDialogUtil.dismissProgressDialog()
                    if (response.data.isNotEmpty()) {
                        adapter.submitList(response.data.toMutableList())
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



    private fun getData() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (isOnline()) {
                callingListViewModel.getCallListData()
            } else {
                withContext(Dispatchers.Main) {
                    showToast("You are not online")
                }
            }
        }
    }


}