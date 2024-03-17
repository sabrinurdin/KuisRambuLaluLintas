package com.example.kuisrambulalulintas.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table2")
data class HistoryEntity2(
    @PrimaryKey(autoGenerate = true)
    val kuisId: Int = 0,
    val name: String,
    val score: Int,
) {

}
