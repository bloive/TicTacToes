package com.example.shemajamebeli4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shemajamebeli4.databinding.FragmentSecondBinding
import kotlin.math.sqrt

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val images = mutableListOf<ItemModel>()
    private lateinit var adapter: RecyclerAdapter
    private var result = 9
    private var click = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        init()
        setData()
        return binding.root
    }

    private fun init() {
        result = arguments?.getInt("key", 9)!!
        adapter = RecyclerAdapter(images,  click,  object : ClickHandler {
            override fun itemOnClick(position: Int) {
                if (click % 2 == 0) {
                    images[position].image = R.drawable.ic_zero
                } else {
                    images[position].image = R.drawable.ic_x
                }
                click++
                adapter.notifyDataSetChanged()
            }
        })
        binding.recycler.layoutManager = GridLayoutManager(activity, sqrt(result.toDouble()).toInt())
        binding.recycler.adapter = adapter
    }

    private fun setData() {
        for (i in 1..result) {
            images.add(ItemModel())
        }
        adapter.notifyDataSetChanged()
    }
}