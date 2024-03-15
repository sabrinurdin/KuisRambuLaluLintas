package com.example.kuisrambulalulintas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kuisrambulalulintas.data.local.entity.HistoryEntity

@Database(
    entities = [HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class KuisDatabase :  RoomDatabase() {

    abstract fun kuisDao() : KuisDao

    companion object {
        @Volatile
        private var INSTANCE: KuisDatabase? = null

        fun getInstance(context: Context) : KuisDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context)
            }

        private fun buildDatabase(context: Context): KuisDatabase {
            return Room.databaseBuilder(
                context,
                KuisDatabase::class.java,"kuis.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}