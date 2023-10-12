package com.example.todoapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Model.CallListing
import com.example.todoapp.Model.CallListingItem
import com.example.todoapp.R
import com.example.todoapp.databinding.CallingListItemsLayoutBinding


class CallListAdapter(
    private val context: Context,
    ) : RecyclerView.Adapter<CallListAdapter.CallListViewHolder>() {

    private var list: MutableList<CallListingItem> = mutableListOf()

    class CallListViewHolder(private val binding: CallingListItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(list: CallListingItem){
            binding.callListNameID.text = list.name
            binding.callListNumberID.text = list.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListViewHolder {
        val binding = CallingListItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallListViewHolder, position: Int) {
        val callList = list[position]
        holder.bind(callList)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun submitList(mList: MutableList<CallListingItem>){
        this.list = mList
        notifyDataSetChanged()
    }

}


