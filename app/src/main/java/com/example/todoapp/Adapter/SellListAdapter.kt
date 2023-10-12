package com.example.todoapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Entity.SellItemsEntity
import com.example.todoapp.databinding.SellListItemsLayoutBinding


class SellListAdapter(
    private val context: Context,private val deleteListener: SellItemDeleteListener
) : RecyclerView.Adapter<SellListAdapter.SellListViewHolder>() {
    private var list = mutableListOf<SellItemsEntity>()



    class SellListViewHolder( val binding: SellListItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(list: SellItemsEntity){
            binding.buyerNameID.text = list.name
            binding.priceListID.text = list.price.toString()
            binding.quantityValueId.text = list.quantity.toString()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellListViewHolder {
        val binding = SellListItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SellListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SellListViewHolder, position: Int) {
        val sellList = list[position]
      holder.bind(sellList)
        holder.binding.imageViewDelete.setOnClickListener {
            deleteListener.onDeleteItemClicked(sellList)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun submitList(toMutableList: MutableList<SellItemsEntity>) {
        this.list = toMutableList
        notifyDataSetChanged()
    }

    interface SellItemDeleteListener {
        fun onDeleteItemClicked(id: SellItemsEntity)
    }

}


