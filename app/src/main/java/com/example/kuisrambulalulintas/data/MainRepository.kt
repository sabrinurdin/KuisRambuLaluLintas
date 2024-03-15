package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getKuis(resul : (Resource<List<DataSoal>>) -> Unit)

    suspend fun addHistory(name: String,score: Int)

    suspend fun getAllHistory(): Flow<List<HistoryEntity>>
}