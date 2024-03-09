package com.example.kuisrambulalulintas.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.fragment.findNavController
import com.example.kuisrambulalulintas.MainActivity
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


        binding.buttonBack.setOnClickListener {
            startActivity(Intent(context,MainActivity::class.java))
            finishAffinity(requireActivity())
        }


        binding.cvLarangan.setOnClickListener {
            val data = MenuMateriFragmentDirections.actionMenuMateriFragmentToMateriFragment(1)
            findNavController().navigate(data)
        }

        binding.cvPeringatan.setOnClickListener {
            val data = MenuMateriFragmentDirections.actionMenuMateriFragmentToMateriFragment(2)
            findNavController().navigate(data)
        }

        binding.cvPerintah.setOnClickListener {
            val data = MenuMateriFragmentDirections.actionMenuMateriFragmentToMateriFragment(3)
            findNavController().navigate(data)
        }

        binding.cvPetunjuk.setOnClickListener {
            val data = MenuMateriFragmentDirections.actionMenuMateriFragmentToMateriFragment(4)
            findNavController().navigate(data)
        }


        return binding.root
    }

}