package com.example.todoapp.Repository.implementation

import android.content.Context
import com.example.todoapp.Dao.SellItemsDao
import com.example.todoapp.Entity.SellItemsEntity
import com.example.todoapp.Repository.abstraction.SellListRepo
import com.example.todoapp.database.AppDatabase

class SellListRepoImp(private val context: Context , private val dao: SellItemsDao) : SellListRepo{
    override suspend fun insetDataToDB(list: List<SellItemsEntity>) {
        dao.insertSellItems(list)
    }

    override suspend fun getDataFromDB(): List<SellItemsEntity> {
        return dao.getSellItems()

    }

    override suspend fun deleteItemFromDB(myId:Int) {
        return dao.deleteSellItem(myId)
    }

}