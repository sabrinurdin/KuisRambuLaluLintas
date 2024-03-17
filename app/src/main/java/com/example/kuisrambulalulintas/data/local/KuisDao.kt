package com.example.kuisrambulalulintas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity2
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity3
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity4
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity5
import kotlinx.coroutines.flow.Flow

@Dao
interface KuisDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyEntity: HistoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert2(historyEntity: HistoryEntity2)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert3(historyEntity: HistoryEntity3)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert4(historyEntity: HistoryEntity4)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert5(historyEntity: HistoryEntity5)

    @Query("SELECT * FROM HISTORY_TABLE ORDER BY kuisId DESC")
        fun getAllHistoryKuis(): Flow<List<HistoryEntity>>

    @Query("SELECT * FROM HISTORY_TABLE2 ORDER BY kuisId DESC")
    fun getAllHistoryKuis2(): Flow<List<HistoryEntity2>>

    @Query("SELECT * FROM HISTORY_TABLE3 ORDER BY kuisId DESC")
    fun getAllHistoryKuis3(): Flow<List<HistoryEntity3>>

    @Query("SELECT * FROM HISTORY_TABLE4 ORDER BY kuisId DESC")
    fun getAllHistoryKuis4(): Flow<List<HistoryEntity4>>

    @Query("SELECT * FROM HISTORY_TABLE5 ORDER BY kuisId DESC")
    fun getAllHistoryKuis5(): Flow<List<HistoryEntity5>>
}