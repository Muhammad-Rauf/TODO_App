package com.example.todoapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Model.BuyListingItem
import com.example.todoapp.Model.CallListingItem
import com.example.todoapp.R
import com.example.todoapp.databinding.BuyListItemsLayoutBinding
import com.example.todoapp.databinding.CallingListItemsLayoutBinding


class BuyListAdapter(
    private val context: Context
) : RecyclerView.Adapter<BuyListAdapter.BuyListViewHolder>() {

    private var list = mutableListOf<BuyListingItem>()

    class BuyListViewHolder(private val binding: BuyListItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(list: BuyListingItem){
            binding.buyerNameID.text = list.name
            binding.priceListID.text = list.price.toString()
            binding.quantityValueId.text = list.quantity.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyListViewHolder {
        val binding = BuyListItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyListViewHolder, position: Int) {
        val buyList = list[position]
        holder.bind(buyList)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(toMutableList: MutableList<BuyListingItem>) {
        this.list = toMutableList
        notifyDataSetChanged()
    }

}


