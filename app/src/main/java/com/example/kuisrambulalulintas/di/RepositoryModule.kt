package com.example.kuisrambulalulintas.di

import com.example.kuisrambulalulintas.data.MainRepository
import com.example.kuisrambulalulintas.data.MainRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideMainRepository(
        database : FirebaseFirestore
    ) : MainRepository {
        return MainRepositoryImpl(database)
    }
}