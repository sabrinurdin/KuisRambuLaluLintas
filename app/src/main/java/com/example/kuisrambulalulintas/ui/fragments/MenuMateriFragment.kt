package com.example.kuisrambulalulintas.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.FragmentMenuMateriBinding

class MenuMateriFragment : Fragment() {

    private lateinit var binding : FragmentMenuMateriBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuMateriBinding.inflate(layoutInflater, container, false)


        binding.cvLarangan.setOnClickListener {
            findNavController().navigate(R.id.action_menuMateriFragment_to_materiFragment)
        }


        return binding.root
    }
}