package com.example.todoapp.Repository.abstraction

import com.example.todoapp.Entity.SellItemsEntity

interface SellListRepo {
    suspend fun insetDataToDB(list: List<SellItemsEntity>)
    suspend fun getDataFromDB(): List<SellItemsEntity>
     suspend fun deleteItemFromDB(int: Int)
}