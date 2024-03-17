package com.example.kuisrambulalulintas.data

import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity2
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity5
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getKuis(resul : (Resource<List<DataSoal>>) -> Unit)

    suspend fun addHistory(name: String,score: Int)
    suspend fun addHistory2(name: String,score: Int)
    suspend fun addHistory3(name: String,score: Int)
    suspend fun addHistory4(name: String,score: Int)
    suspend fun addHistory5(name: String,score: Int)

    suspend fun getAllHistory(): Flow<List<HistoryEntity>>

    suspend fun getAllHistory2(): Flow<List<HistoryEntity2>>

    suspend fun getAllHistory3(): Flow<List<HistoryEntity3>>

    suspend fun getAllHistory4(): Flow<List<HistoryEntity4>>

    suspend fun getAllHistory5(): Flow<List<HistoryEntity5>>


}