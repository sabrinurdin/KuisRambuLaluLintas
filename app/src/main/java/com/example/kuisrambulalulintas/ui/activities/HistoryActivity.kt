package com.example.kuisrambulalulintas.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.adapter.HistoryAdapter
import com.example.kuisrambulalulintas.adapter.HistoryAdapter2
import com.example.kuisrambulalulintas.adapter.HistoryAdapter3
import com.example.kuisrambulalulintas.adapter.HistoryAdapter4
import com.example.kuisrambulalulintas.adapter.HistoryAdapter5
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity2
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity5
import com.example.kuisrambulalulintas.databinding.ActivityHistoryBinding
import com.example.kuisrambulalulintas.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel : MainViewModel by viewModels()

    private lateinit var recycleview : RecyclerView

    private var idLevel : Int? = null
    private var question : Int? = null

    private  var historyList : List<HistoryEntity> = emptyList()
    private  var historyList2 : List<HistoryEntity2> = emptyList()
    private  var historyList3 : List<HistoryEntity3> = emptyList()
    private  var historyList4 : List<HistoryEntity4> = emptyList()
    private  var historyList5 : List<HistoryEntity5> = emptyList()

    private lateinit var adapter : HistoryAdapter
    private lateinit var adapter2 : HistoryAdapter2
    private lateinit var adapter3 : HistoryAdapter3
    private lateinit var adapter4 : HistoryAdapter4
    private lateinit var adapter5 : HistoryAdapter5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idLevel = intent.getIntExtra("idLevel",0)
        question = intent.getIntExtra("question",0)

        val bindingToolbar = binding.toolbar.toolbara
        bindingToolbar.title = "Riwayat level $idLevel"
        bindingToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
        setSupportActionBar(bindingToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        getHistory(idLevel!!)
        //initRecycleview(historyList)


    }

    private fun getHistory(idLevel: Int) {

        if (idLevel == 1) {
            viewModel.getAllHistory()
            viewModel.readHistory.observe(this){
                historyList = it!!
                initRecycleview(historyList)

                Log.d("HISTORYENTITY","$it")
            }
        } else if (idLevel == 2){
            viewModel.getAllHistory2()
            viewModel.readHistory2.observe(this){
                historyList2 = it!!
                initRecycleview2(historyList2)

                Log.d("HISTORYENTITY","$it")
            }
        } else if (idLevel == 3){
            viewModel.getAllHistory3()
            viewModel.readHistory3.observe(this){
                historyList3 = it!!
                initRecycleview3(historyList3)

                Log.d("HISTORYENTITY","$it")
            }
        } else if (idLevel == 4){
            viewModel.getAllHistory4()
            viewModel.readHistory4.observe(this){
                historyList4 = it!!
                initRecycleview4(historyList4)

                Log.d("HISTORYENTITY","$it")
            }
        } else if (idLevel == 5){
            viewModel.getAllHistory5()
            viewModel.readHistory5.observe(this){
                historyList5 = it!!
                initRecycleview5(historyList5)

                Log.d("HISTORYENTITY","$it")
            }
        }

    }

    private fun initRecycleview(historyList: List<HistoryEntity>) {
        val layoutManager = LinearLayoutManager(this)
        adapter = HistoryAdapter(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter
    }

    private fun initRecycleview2(historyList: List<HistoryEntity2>) {
        val layoutManager = LinearLayoutManager(this)
        adapter2 = HistoryAdapter2(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter2
    }

    private fun initRecycleview3(historyList: List<HistoryEntity3>) {
        val layoutManager = LinearLayoutManager(this)
        adapter3 = HistoryAdapter3(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter3
    }

    private fun initRecycleview4(historyList: List<HistoryEntity4>) {
        val layoutManager = LinearLayoutManager(this)
        adapter4 = HistoryAdapter4(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter4
    }

    private fun initRecycleview5(historyList: List<HistoryEntity5>) {
        val layoutManager = LinearLayoutManager(this)
        adapter5 = HistoryAdapter5(historyList, onItemCliked = {_,item ->})
        binding.rvHistory.layoutManager = layoutManager
        binding.rvHistory.adapter = adapter5
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}