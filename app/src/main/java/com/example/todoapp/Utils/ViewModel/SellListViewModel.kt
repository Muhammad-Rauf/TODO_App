package com.example.todoapp.Utils.ViewModel

import androidx.lifecycle.ViewModel
import com.example.todoapp.Entity.SellItemsEntity
import com.example.todoapp.Model.BuyListingItem
import com.example.todoapp.Repository.abstraction.SellListRepo

class SellListViewModel(private val sellListRepo: SellListRepo) : ViewModel() {

  suspend  fun saveData(toMutableList: MutableList<BuyListingItem>) {
      val saveList = toMutableList.map {
          SellItemsEntity(
             id = it.id, name = it.name, price = it.price, quantity = it.quantity, type = 2
          )
      }
      sellListRepo.insetDataToDB(saveList)
    }
   suspend fun getData() = sellListRepo.getDataFromDB()


    suspend fun deleteSellItem(int: Int) = sellListRepo.deleteItemFromDB(int)
}