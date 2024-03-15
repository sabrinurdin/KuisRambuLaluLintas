package com.example.kuisrambulalulintas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KuisDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("SELECT * FROM HISTORY_TABLE ORDER BY kuisId ASC")
        fun getAllHistoryKuis(): Flow<List<HistoryEntity>>
}