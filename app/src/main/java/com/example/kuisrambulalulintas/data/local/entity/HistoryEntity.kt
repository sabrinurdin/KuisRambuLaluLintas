package com.example.kuisrambulalulintas.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val kuisId: Int = 0,
    val name: String,
    val score: Int,
) {

}
