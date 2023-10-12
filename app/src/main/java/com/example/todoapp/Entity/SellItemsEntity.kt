package com.example.todoapp.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemToSell")
 class SellItemsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0 ,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int
)