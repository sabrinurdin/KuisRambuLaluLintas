package com.example.kuisrambulalulintas.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuisrambulalulintas.adapter.HistoryAdapter
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.databinding.ActivityHistoryBinding
import com.example.kuisrambulalulintas.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel : MainViewModel by viewModels()

    private lateinit var recycleview : RecyclerView

    private  var historyList : List<HistoryEntity> = emptyList()

    private lateinit var adapter : HistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getHistory()
        //initRecycleview(historyList)


    }

    private fun getHistory() {
        viewModel.getAllHistory()
        viewModel.readHistory.observe(this){
            historyList = it!!
            initRecycleview(historyList)

            Log.d("HISTORYENTITY","$it")
        }
    }

    private fun initRecycleview(historyList: List<HistoryEntity>) {
        val layoutManager = LinearLayoutManager(this)
        adapter = HistoryAdapter(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter
    }


}