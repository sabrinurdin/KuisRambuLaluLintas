package com.example.kuisrambulalulintas.di

import android.content.Context
import com.example.kuisrambulalulintas.data.local.KuisDao
import com.example.kuisrambulalulintas.data.local.KuisDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideKuisDatabase(@ApplicationContext context: Context): KuisDao {
        return KuisDatabase.getInstance(context).kuisDao()
    }
}