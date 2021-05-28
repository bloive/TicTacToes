package com.example.shemajamebeli4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.shemajamebeli4.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        binding.btn9.setOnClickListener {
            val bundle = bundleOf("key" to 9)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
        binding.btn16.setOnClickListener {
            val bundle = bundleOf("key" to 16)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
        binding.btn25.setOnClickListener {
            val bundle = bundleOf("key" to 16)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }



}