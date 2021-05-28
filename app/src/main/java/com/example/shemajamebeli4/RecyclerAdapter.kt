package com.example.shemajamebeli4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli4.databinding.ViewLayoutBinding

class RecyclerAdapter(private val images: MutableList<ItemModel>, val click: Int, val clickListener: ClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder)
            holder.bind()
    }

    override fun getItemCount(): Int = images.size

    inner class ItemViewHolder(private val binding: ViewLayoutBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind() {
            if (click % 2 == 0) {
                binding.imageView.setImageResource(R.drawable.ic_zero)
            } else {
                binding.imageView.setImageResource(R.drawable.ic_x)
            }
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener.itemOnClick(adapterPosition)
        }
    }

}


