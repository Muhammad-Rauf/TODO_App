package com.example.todoapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoapp.Entity.SellItemsEntity

@Dao
interface SellItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSellItems(memes: List<SellItemsEntity>)

    @Query("SELECT * FROM ItemToSell")
    fun getSellItems(): List<SellItemsEntity>

    @Query("DELETE FROM ItemToSell WHERE id=:id")
    fun deleteSellItem(id:Int)

}