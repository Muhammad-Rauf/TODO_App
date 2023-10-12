package com.example.todoapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.Adapter.SellListAdapter
import com.example.todoapp.Entity.SellItemsEntity
import com.example.todoapp.Model.CallListingItem
import com.example.todoapp.Utils.showToast
import com.example.todoapp.Utils.ViewModel.SellListViewModel
import com.example.todoapp.databinding.ActivitySellListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.notify
import org.koin.androidx.viewmodel.ext.android.viewModel

class SellListActivity : AppCompatActivity(), SellListAdapter.SellItemDeleteListener {
    private lateinit var binding: ActivitySellListBinding
    private val sellListViewModel : SellListViewModel by  viewModel()
    private val adapter by lazy { SellListAdapter(this,this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySellListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SellListRecyclerView.adapter = adapter
        getData()

    }
    private fun getData() {
            lifecycleScope.launch(Dispatchers.IO) {
           val sellList= sellListViewModel.getData()

            withContext(Dispatchers.Main){
                if (sellList.isEmpty()){
                    showToast("List is Empty")
                }
                else{
                    adapter.submitList(sellList.toMutableList())
                }


            }

        }

        }

    override fun onDeleteItemClicked(list: SellItemsEntity) {
        lifecycleScope.launch(Dispatchers.IO) {
            sellListViewModel.deleteSellItem(list.id)
            withContext(Dispatchers.Main){
                showToast("Sell Item Delete Successfully")
                lifecycleScope.launch(Dispatchers.IO) {
                    val sellList= sellListViewModel.getData()

                    withContext(Dispatchers.Main){
                        if (sellList.isEmpty()){
                            showToast("List is Empty")
                            adapter.submitList(sellList.toMutableList())
                        }
                        else{
                            adapter.submitList(sellList.toMutableList())
                        }


                    }

                }
            }


        }

    }
}
