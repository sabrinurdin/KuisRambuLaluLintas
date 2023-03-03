package com.example.kuisrambulalulintas.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.FragmentMateriBinding
import com.example.kuisrambulalulintas.model.Gambar
import com.example.kuisrambulalulintas.utils.Constants

class MateriFragment : Fragment() {

    private lateinit var binding: FragmentMateriBinding

    private val args : MateriFragmentArgs by navArgs()

    private val rambuLaranganList = Constants.getRambuLarangan()
    private val rambuPeringatanList = Constants.getRambuPeringatan()
    private val rambuPerintahList = Constants.getRambuPerintah()
    private val rambuPetunjukList = Constants.getRambuLPetunjuk()
    private var gambarList : ArrayList<Gambar>? = null
    private var selectIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMateriBinding.inflate(layoutInflater, container, false)


        val currentGambar = rambuLaranganList[selectIndex]

        if (args.rambu == 1){
            gambarList = rambuLaranganList
            binding.clBackground.setBackgroundResource(R.drawable.bg_larangan)
        } else if (args.rambu == 2){
            gambarList = rambuPeringatanList
            binding.clBackground.setBackgroundResource(R.drawable.bg_peringatan)
        }
        else if (args.rambu == 3){
            gambarList = rambuPerintahList
            binding.clBackground.setBackgroundResource(R.drawable.bg_perintah)
        } else {
            gambarList = rambuPetunjukList
            binding.clBackground.setBackgroundResource(R.drawable.bg_petunjuk)
        }


        updateGambar(selectIndex)

        binding.btnNext.setOnClickListener {
            if (selectIndex < gambarList!!.size - 1) {
                selectIndex++
                updateGambar(selectIndex)

                Log.d("selectIndex", "$selectIndex")
                Log.d("selectIndex", "${gambarList!!.size - 1} ${gambarList!!.size}")
            }

        }

        binding.btnPrev.setOnClickListener {
            if (selectIndex < gambarList!!.size) {
                    selectIndex--
                    updateGambar(selectIndex)
            }
        }

        return binding.root
    }

    private fun updateGambar(selectIndex: Int) {

        if (selectIndex == 0) {
            binding.btnPrev.visibility = View.GONE
        } else if (selectIndex == gambarList!!.size - 1) {
            binding.btnNext.visibility = View.GONE
        } else {
            binding.btnNext.visibility = View.VISIBLE
            binding.btnPrev.visibility = View.VISIBLE
        }
        binding.ivRambu.setImageResource(gambarList!![selectIndex].gambar)
        binding.tvKeterangan.text = gambarList!![selectIndex].keterangan
    }
}